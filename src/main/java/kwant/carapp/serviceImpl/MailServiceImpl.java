package kwant.carapp.serviceImpl;

import org.springframework.stereotype.Service;

import kwant.carapp.model.Car;
import kwant.carapp.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Service 
public class MailServiceImpl implements MailService{  
	
	@Autowired
	private JavaMailSender javaMailSender;	

	@Override
	public void sendMail(Car car) throws MessagingException {
		// TODO Auto-generated method stub
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		 
		helper = new MimeMessageHelper(message, true); // true indicates
													   // multipart message
		helper.setSubject("zlecenia@kwant.com.pl");
		helper.setTo("zlecenia@kwant.com.pl");
		helper.setText("Test Mail", true);
		
		
		
		// true indicates html
		// continue using helper object for more functionalities like adding attachments, etc.  
		
		javaMailSender.send(message);
		
	} 

	
//	public void sendMail(Car car) {
//		// TODO Auto-generated method stub
//		
//	}

}
