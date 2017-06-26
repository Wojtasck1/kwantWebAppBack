package kwant.carapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kwant.carapp.model.Car;
import kwant.carapp.repository.CarRepository;
import kwant.carapp.service.CarService;
 
@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	CarRepository carRepository;
	
	public void delete(Long carId){
		carRepository.delete(carRepository.findOne(carId));
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car save(Car car) {
		return carRepository.saveAndFlush(car);
		
	}

	@Override
	public Car findCar(Long carId) {
		return carRepository.findOne(carId);
	}

	@Override
	public Car update(Car car) { 
		return carRepository.saveAndFlush(car);
	}
}
