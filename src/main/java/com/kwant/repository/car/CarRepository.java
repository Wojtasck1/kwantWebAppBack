package com.kwant.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.car.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
