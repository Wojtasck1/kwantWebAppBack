package com.kwant.util.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kwant.entity.User;
import com.kwant.entity.car.Car;
import com.kwant.repository.car.CarRepository;
import com.kwant.util.MailUtil;
import com.kwant.repository.UserRepository;
import com.kwant.util.ExpirationUtil;

@Component
@PropertySource("classpath:/applicationConfig.properties")
public class ExpirationDate {

	@Autowired
	private ExpirationUtil expirationUtil;

	@Autowired
	CarRepository carRepository;

	@Autowired
	private MailUtil mailService;

	@Autowired
	private UserRepository userRepository;

	@Value("${info.dni.do.konca.przegladu}")
	Integer daysToOverviewEnd;
	@Value("${info.dni.do.konca.ubezpieczenia}")
	Integer daysToInsuranceEnd;
	@Value("${info.termin.kontroli.przebiegu}")
	Integer daysToOilCheck;
	@Value("${info.przebieg.do.kontroli}") 
	Integer distanceToOilChange;

	private List<Car> carsWitchExpiredOverview = new ArrayList<Car>();

	private List<Car> carsWitchExpiredInsurence = new ArrayList<Car>();

	private List<Car> carsToOilCheck = new ArrayList<Car>();
	

	private String messageCreator(Car car, String message, String data) {
		User user = userRepository.findOne(car.getUsersId()); 
		return "W samochód o numerze rejestracyjnym :" + car.getPlates() + "/n" + " zakończy się " + message
				+ "w ciągu najbliższych 7 dni dokładna data:" + data + "użytkownik samochodu:" + user.getName() + " "
				+ user.getSurname();
	}

	@Scheduled(cron = "* * * */1 * *")
	private void triggerOverviewDateCheck() {
		carsWitchExpiredOverview = expirationUtil.getCarsWitchExpireOverviev(daysToOverviewEnd);
		for (Car car : carsWitchExpiredOverview) {
			try {
				mailService.sendMail(car, messageCreator(car, "przegląd", car.getOverview().toString()));
				car.setUserAverOfOverviewExpiration(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace(); 
			} 
		}
	}

	@Scheduled(cron = "* * * */1 * *")
	private void triggerCourseCheck() { 
		carsWitchExpiredInsurence = expirationUtil.getCarsWitchExpireInsurance(daysToInsuranceEnd);
		for (Car car : carsWitchExpiredInsurence) {
			try {
				mailService.sendMail(car, messageCreator(car, "ubezpieczenie", car.getInsurance().toString()));
				car.setUserAverOfInsuranceExpiration(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	@Scheduled(cron = "* * * */1 * *")
	private void triggerOilCheck() {
		carsToOilCheck = expirationUtil.getCarsWitchOldOil(distanceToOilChange);
		for (Car car : carsToOilCheck) {
			try {
				mailService.sendMail(car,
						"W samochodzie o nr " + car.getPlates() + " rejestracyjnych należy wymienić olej");
				car.setUserAverOfOilChange(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
}