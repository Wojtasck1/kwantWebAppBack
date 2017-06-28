package kwant.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kwant.carapp.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
