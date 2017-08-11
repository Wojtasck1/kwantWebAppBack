package com.kwant.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.car.CarNote;

public interface CarNoteRepository extends JpaRepository<CarNote, Long> {

}
