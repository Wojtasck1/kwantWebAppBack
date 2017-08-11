package com.kwant.util;

import org.springframework.stereotype.Service;

import com.kwant.entity.User;
import com.kwant.entity.car.Car;
import com.kwant.repository.UserRepository;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Service 
@PropertySource("classpath:/applicationConfig.properties")
public class MailUtil{ 
	
	@Value("${spring.mail.username}")
	String hostName;
	
	@Value("${spring.mail.default}")
	String defaultEmailAdres;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private UserRepository userRepository; 
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(Car car, String inputMessage) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		
		User user = userRepository.findOne(car.getUsersId());
		String userMail = user.getEmail();
		
		System.out.println(userMail);  
	
		message.setFrom(hostName);  
		message.setTo(userMail);
		message.setTo(defaultEmailAdres);
		message.setSubject("Informacja techniczna na temat samochodu:" + car.getPlates());
		message.setText(inputMessage);
		mailSender.send(message);
	} 
}