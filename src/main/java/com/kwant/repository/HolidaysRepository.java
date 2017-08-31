package com.kwant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.Holiday;

public interface HolidaysRepository extends JpaRepository<Holiday, Long> {
	
	public List<Holiday> getHolidayByUserId(Long UserId);

}
