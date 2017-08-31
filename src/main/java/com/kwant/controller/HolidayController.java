package com.kwant.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kwant.entity.Holiday;
import com.kwant.entity.car.CarNote;
import com.kwant.repository.HolidaysRepository;

@RestController
@RequestMapping("api/v1/")
public class HolidayController {
	
	@Autowired
	HolidaysRepository holidaysRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "holidays", method = RequestMethod.GET , produces = "application/json")
	public List<Holiday> list() {
		return holidaysRepository.findAll();
	}

	@RequestMapping(value = "holidays", method = RequestMethod.POST)
	public Holiday create(@RequestBody Holiday holiday) {
		return holidaysRepository.save(holiday);
	} 

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "holidays/{id}", method = RequestMethod.GET)
	public Holiday get(@PathVariable Long id) {
		return holidaysRepository.findOne(id);
	} 
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "holidays/userId/{id}", method = RequestMethod.GET)
	public List<Holiday> getHolidayByUserId(@PathVariable Long id) {
		return holidaysRepository.getHolidayByUserId(id);
	} 

	@RequestMapping(value = "holidays/{id}", method = RequestMethod.PUT)
	public Holiday update(@PathVariable Long id, @RequestBody Holiday holiday) {
		Holiday existingHoliday = holidaysRepository.findOne(id);
		BeanUtils.copyProperties(holiday, existingHoliday);
		return holidaysRepository.save(existingHoliday);
	}

	@RequestMapping(value = "holidays/{id}", method = RequestMethod.DELETE)
	public Holiday delete(@PathVariable Long id) {
		Holiday holiday = holidaysRepository.findOne(id); 
		holidaysRepository.delete(id);
		return holiday;
	}

}
