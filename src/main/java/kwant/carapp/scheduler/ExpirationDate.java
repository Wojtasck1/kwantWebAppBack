package kwant.carapp.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kwant.carapp.model.Car;
import kwant.carapp.model.User;
import kwant.carapp.repository.CarRepository;
import kwant.carapp.service.CarService;
import kwant.carapp.service.MailService;
import kwant.carapp.service.UserService;
import kwant.carapp.util.ExpirationUtil;

@Component
@PropertySource("classpath:/applicationConfig.properties")
public class ExpirationDate { 

	@Autowired
	private ExpirationUtil expirationUtil;
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private UserService userService;
	
	@Value("${info.dni.do.konca.przegladu}")
	Integer daysToOverviewEnd;
	@Value("${info.dni.do.konca.ubezpieczenia}")
	Integer daysToInsuranceEnd;
	@Value("${info.termin.kontroli.przebiegu}")
	Integer daysToOilCheck;

	private List<Car> carsWitchExpiredOverview = new ArrayList<Car>();

	private List<Car> carsWitchExpiredInsurence = new ArrayList<Car>();

	private List<Car> carsToOilCheck = new ArrayList<Car>();
	
	
	
	private String messageCreator(Car car, String message, String data){
		User user = userService.findUser(car.getUsersId());
		return"W samochód o numerze rejestracyjnym :" + car.getPlates() + "/n"
				+ " zakończy się " + message + "w ciągu najbliższych 7 dni dokładna data:" + data + "użytkownik samochodu:" + user.getName() + " " + user.getSurname();
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void triggerOverviewDateCheck() {
		System.out.println("-------------- samochody z wychodzącym przeglądem ----------");
		carsWitchExpiredOverview = expirationUtil.getCarsWitchExpireOverviev(daysToOverviewEnd);
		for(Car car:carsWitchExpiredOverview){
			try {
				mailService.sendMail(car, messageCreator(car , "przegląd" , car.getOverview().toString()));
				car.setUserAverOfOverviewExpiration(true);
				carRepository.saveAndFlush(car);
				System.out.println(" wysłałem maila ");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
 
	@Scheduled(cron = "*/2 * * * * *")
	public void triggerCourseCheck() {
		System.out.println("-------------- samochody z wychodzącym ubezpieczeniem ----------");
		carsWitchExpiredInsurence = expirationUtil.getCarsWitchExpireInsurance(daysToInsuranceEnd);
		for(Car car:carsWitchExpiredInsurence){
			try {
				mailService.sendMail(car, messageCreator(car , "ubezpieczenie" , car.getInsurance().toString()));
				car.setUserAverOfInsuranceExpiration(true);
				carRepository.saveAndFlush(car);
			} catch (MessagingException e) { 
				e.printStackTrace();
			}
		} 
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void triggerOilCheck() {
//		System.out.println("-------------- samochody do spisania przebiegu ----------");
//		System.out.println("-------------- samochody do spisania przebiegu ----------");
//		System.out.println("-------------- samochody do spisania przebiegu ----------");
	}

}
