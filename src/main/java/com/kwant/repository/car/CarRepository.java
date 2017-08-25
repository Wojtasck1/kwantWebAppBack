package com.kwant.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.car.Car;
import com.kwant.entity.car.CarNote;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	//public List<CarNote> getNoteListByCarId(Long carId);

}
