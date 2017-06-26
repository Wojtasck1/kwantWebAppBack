package kwant.carapp.util;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import kwant.carapp.model.Car;
import kwant.carapp.service.CarService;

@Component
public class ExpirationUtil {

	@Autowired
	Environment environment;

	@Autowired 
	public CarService carService;

	private List<Car> allCars;

	public List<Car> getCarsWitchExpireInsurance(Integer days) {
		List<Car> carsWitchExpiredInsurance = new ArrayList<Car>();
		allCars = carService.findAll(); 

		for (Car car : allCars) {
			if (car.getInsurance().after(getDateBackwords(days)) && car.getInsurance().before(getDateBackwords(0))) {
				carsWitchExpiredInsurance.add(car);
			}
		}
		return carsWitchExpiredInsurance;
	}

	public List<Car> getCarsWitchExpireOverviev(Integer days) {
		List<Car> carsWitchExpiredOverview = new ArrayList<Car>();
		allCars = carService.findAll();

		for (Car car : allCars) {
			if (car.getOverview().after(getDateBackwords(days)) && car.getOverview().before(getDateBackwords(0))) {
				carsWitchExpiredOverview.add(car);
				System.err.println(car.getPlates());
			}
		}
		return carsWitchExpiredOverview;
	}
 
	public List<Car> getCarsWitchOldOil(Integer days) {
		List<Car> carsWitchOldOil = new ArrayList<Car>();
		allCars = carService.findAll();

		for (Car car : allCars) {
			if (car.getOverview().after(getDateBackwords(days)) && car.getOverview().before(getDateBackwords(0))) {
				carsWitchOldOil.add(car);
			}
		}
		return carsWitchOldOil;
	}

	public Date getDateBackwords(int daysBeforeNow) {
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -daysBeforeNow);
		return cal.getTime();
	}
	
	public void corseCheck(String oldCorse , String newCorse){ 
//		if (oldCorse >>= angle =<< newCorse){
//			
//		}
	}
}
