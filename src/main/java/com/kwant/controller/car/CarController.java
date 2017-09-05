package com.kwant.controller.car;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kwant.entity.car.Car;
import com.kwant.entity.car.CarNote;
import com.kwant.repository.car.CarRepository;

@RestController
@RequestMapping("api/v1/")
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@CrossOrigin 
	@RequestMapping(value = "cars", method = RequestMethod.GET , produces = "application/json") 
	public List<Car> list() {
		return carRepository.findAll();
	}

	@RequestMapping(value = "cars", method = RequestMethod.POST)
	public Car create(@RequestBody Car car) { 
		return carRepository.save(car);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "cars/{id}", method = RequestMethod.GET , produces = "application/json")
	public Car get(@PathVariable Long id) {
		return carRepository.findOne(id);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "cars/{id}", method = RequestMethod.PUT)
	public Car update(@PathVariable Long id, @RequestBody Car car) {
		Car existingCar = carRepository.findOne(id);
		BeanUtils.copyProperties(car, existingCar);
		return carRepository.save(existingCar);
	}

	@RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
	public Car delete(@PathVariable Long id) {
		Car car = carRepository.findOne(id);
		carRepository.delete(id);
		return car;
	}
}