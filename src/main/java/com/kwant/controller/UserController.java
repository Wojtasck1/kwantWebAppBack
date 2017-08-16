package com.kwant.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kwant.entity.User;
import com.kwant.repository.UserRepository;

@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> list() {
		return userRepository.findAll();
	}
 
	@RequestMapping(value = "users/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "users/user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Long id) {
		return userRepository.findOne(id);
	} 

	@RequestMapping(value = "users/user/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody User user) {
		User existinguser = userRepository.findOne(id);
		BeanUtils.copyProperties(user, existinguser);
		return userRepository.save(existinguser);
	}

	@RequestMapping(value = "users/user/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {
		User user = userRepository.findOne(id); 
		userRepository.delete(id);
		return user;
	}

}