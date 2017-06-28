package kwant.carapp.service;

import javax.mail.MessagingException;

import kwant.carapp.model.Car;

public interface MailService {
	
	public void sendMail(Car car ,String message) throws MessagingException;

}
