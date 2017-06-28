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
import kwant.carapp.service.MailService;
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
	
	private String messageCreator(Car car, String message){
		return"W samochód o numerze rejestracyjnym :" + car.getPlates() + "/n"
				+ " zakończy się " + message + "w ciągu najbliższych 7 dni";
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void triggerOverviewDateCheck() {
		System.out.println("-------------- samochody z wychodzącym przeglądem ----------");
		carsWitchExpiredOverview = expirationUtil.getCarsWitchExpireOverviev(daysToOverviewEnd);
		for(Car car:carsWitchExpiredOverview){
			try {
				mailService.sendMail(car, messageCreator(car , "przegląd"));
				car.setUserAverOfOverviewExpiration(true);
			} catch (MessagingException e) {
				System.out.println("Error mail dos not send");
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
				mailService.sendMail(car, messageCreator(car , "ubezpieczenie"));
				car.setUserAverOfOverviewExpiration(true);
			} catch (MessagingException e) { 
				System.out.println("Error mail dos not send");
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
