package kwant.carapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import kwant.carapp.repository.CarRepository;
import kwant.carapp.service.CarService;

public class CarServiceImpl implements CarService{
	
	@Autowired
	CarRepository carRepository;
	
	public void delete(Long carId){
		carRepository.delete(carRepository.findOne(carId));
	}
	
	

}
