package kwant.carapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kwant.carapp.model.Car;
import kwant.carapp.service.CarService;

@RestController
@RequestMapping("api/v1/")
public class CarController {
	
	@Autowired
	CarService carService;
	
	@CrossOrigin 
	@RequestMapping(value = "car", method = RequestMethod.GET , produces = "application/json") 
	public List<Car> list() {
		return carService.findAll();
	}

	@RequestMapping(value = "car", method = RequestMethod.POST)
	public Car create(@RequestBody Car car) {
		return carService.save(car);
	}

	@RequestMapping(value = "car/{id}", method = RequestMethod.GET)
	public Car get(@PathVariable Long id) {
		return carService.findCar(id);
	}

	@RequestMapping(value = "car/{id}", method = RequestMethod.PUT)
	public Car update(@PathVariable Long id, @RequestBody Car car) {
		Car existingCar = carService.findCar(id);
		BeanUtils.copyProperties(car, existingCar);
		return carService.save(existingCar);
	}

	@RequestMapping(value = "car/{id}", method = RequestMethod.DELETE)
	public Car delete(@PathVariable Long id) {
		Car car = carService.findCar(id);
		carService.delete(id);
		return car;
	}

}
