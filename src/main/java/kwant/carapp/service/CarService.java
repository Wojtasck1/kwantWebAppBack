package kwant.carapp.service;

import java.util.List;

import kwant.carapp.model.Car;

public interface CarService {
	
	public void delete(Long carId);
	
	public List<Car> findAll();
	
	public Car save(Car car);
	
	public Car findCar(Long carId);
	
	public Car update(Car car);

}
