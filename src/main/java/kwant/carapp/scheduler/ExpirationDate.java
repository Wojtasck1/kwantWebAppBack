package kwant.carapp.scheduler;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

//import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kwant.carapp.model.Car;
import kwant.carapp.service.CarService;
import kwant.carapp.service.MailService;
//import kwant.carapp.service.MailService;
import kwant.carapp.util.ExpirationUtil;

@Component
@PropertySource("classpath:/applicationConfig.properties")
public class ExpirationDate { 

	@Autowired
	private ExpirationUtil expirationUtil;
	
	@Autowired
	private MailService mailService;
	
	@Value("${info.dni.do.konca.przegladu}")
	Integer daysToOverviewEnd;
	@Value("${info.dni.do.konca.ubezpieczenia}")
	Integer daysToInsuranceEnd;
	@Value("${info.termin.kontroli.przebiegu}")
	Integer daysToOilCheck;

	private List<Car> carsWitchExpiredOverview = new ArrayList<Car>();

	private List<Car> carsWitchExpiredInsurence = new ArrayList<Car>();

	private List<Car> carsToOilCheck = new ArrayList<Car>();

	@Scheduled(cron = "*/2 * * * * *")
	public void triggerExpirationDateCheck() {
		System.out.println("-------------- samochody z wychodzącym przeglądem ----------");
		// carService.findAll();
		carsWitchExpiredOverview = expirationUtil.getCarsWitchExpireOverviev(daysToOverviewEnd);
		for(Car car:carsWitchExpiredOverview){
			System.out.println(car.getPlates());
			try {
				mailService.sendMail(car);
			} catch (MessagingException e) {
				System.out.println("Error mail dos not send");
				e.printStackTrace();
			}
		}
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void triggerCourseCheck() {//throws MessagingException {
		System.out.println("-------------- samochody z wychodzącym ubezpieczeniem ----------");
		carsWitchExpiredInsurence = expirationUtil.getCarsWitchExpireInsurance(daysToInsuranceEnd);
		for(Car car:carsWitchExpiredInsurence){
	//		mailService.sendMail(car);
			System.out.println(car.getPlates()); 
			System.out.println(car.getPlates());
			try {
				mailService.sendMail(car);
				System.out.println("udało się wysłać maila");
			} catch (MessagingException e) {
				System.out.println("Error mail dos not send");
				e.printStackTrace();
			}
		} 
	}

	@Scheduled(cron = "0 0 12 1/90 * *")
	public void triggerOilCheck() {
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
		System.out.println("-------------- samochody do spisania przebiegu ----------");
	}

}
