package com.kwant.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.car.CarNote;

public interface CarNoteRepository extends JpaRepository<CarNote, Long> {
	
	public List<CarNote> getNoteByCarId(Long carId); 

} 
