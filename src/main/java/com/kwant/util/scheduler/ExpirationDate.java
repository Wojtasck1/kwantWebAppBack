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
	private Integer daysToOverviewEnd;
	@Value("${info.dni.do.konca.ubezpieczenia}")
	private Integer daysToInsuranceEnd;
	@Value("${info.termin.kontroli.przebiegu}")
	private Integer daysToOilCheck;
	@Value("${info.przebieg.do.kontroli}") 
	private Integer distanceToOilChange;
	
	@Value("${info.przebieg}") 
	private String przegląd;
	
	@Value("${info.ubezpieczenie}") 
	private String ubezpieczenie;

	private List<Car> carsWitchExpiredOverview = new ArrayList<Car>();

	private List<Car> carsWitchExpiredInsurence = new ArrayList<Car>();

	private List<Car> carsToOilCheck = new ArrayList<Car>();
	

	private String messageCreator(Car car, String message, String data) {
		User user = userRepository.findOne(car.getUsersId()); 
		return String.format("Samochód o numerze rejestracyjnym : %s zakończy się "
				+ "%s w ciągu najbliższych 7 dni dokładna data %s użytkownik samochodu: %s %s", 
				car.getPlates() , message , data , user.getName() , user.getSurname());
	}

//	@Scheduled(cron = "* * * */1 * *")
	private void triggerOverviewDateCheck() {
		carsWitchExpiredOverview = expirationUtil.getCarsWitchExpireOverviev(daysToOverviewEnd);
		for (Car car : carsWitchExpiredOverview) {
			try {
				mailService.sendMail(car, messageCreator(car, przegląd, car.getOverview().toString()));
				car.setUserAverOfOverviewExpiration(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace(); 
			} 
		}
	}

//	@Scheduled(cron = "* * * */1 * *")
	private void triggerCourseCheck() { 
		carsWitchExpiredInsurence = expirationUtil.getCarsWitchExpireInsurance(daysToInsuranceEnd);
		for (Car car : carsWitchExpiredInsurence) {
			try {
				mailService.sendMail(car, messageCreator(car, ubezpieczenie, car.getInsurance().toString()));
				car.setUserAverOfInsuranceExpiration(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

//	@Scheduled(cron = "* * * */1 * *")
	private void triggerOilCheck() {
		carsToOilCheck = expirationUtil.getCarsWitchOldOil(distanceToOilChange);
		for (Car car : carsToOilCheck) {
			try { 
				mailService.sendMail(car, String.format("W samochodzie o nr %s rejestracyjnych należy wymienić olej", car.getPlates()));
				car.setUserAverOfOilChange(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
}