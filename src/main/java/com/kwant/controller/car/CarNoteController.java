package com.kwant.controller.car;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kwant.entity.car.CarNote;
import com.kwant.repository.car.CarNoteRepository;

@RestController
@RequestMapping("api/v1/")
public class CarNoteController {

	@Autowired
	CarNoteRepository carRepository;
	
	@RequestMapping(value = "carNotes", method = RequestMethod.GET)
	public List<CarNote> list() {
		return carRepository.findAll();
	}

	@RequestMapping(value = "carNotes", method = RequestMethod.POST)
	public CarNote create(@RequestBody CarNote note) {
		return carRepository.save(note);
	}

	@RequestMapping(value = "carNotes/{id}", method = RequestMethod.GET)
	public CarNote get(@PathVariable Long id) {
		return carRepository.findOne(id);
	} 
	
//	@RequestMapping(value = "carNotes/carId/{id}", method = RequestMethod.GET)
//	public List<CarNote> getNotesByCarId(@PathVariable Long id) {
//		return carRepository.getNoteByCardId(id);
//	} 

	@RequestMapping(value = "carNotes/{id}", method = RequestMethod.PUT)
	public CarNote update(@PathVariable Long id, @RequestBody CarNote note) {
		CarNote existingNote = carRepository.findOne(id);
		BeanUtils.copyProperties(note, existingNote);
		return carRepository.save(existingNote);
	}

	@RequestMapping(value = "carNotes/{id}", method = RequestMethod.DELETE)
	public CarNote delete(@PathVariable Long id) {
		CarNote note = carRepository.findOne(id); 
		carRepository.delete(id);
		return note;
	}
}