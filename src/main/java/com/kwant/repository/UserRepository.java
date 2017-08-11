package com.kwant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwant.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
  