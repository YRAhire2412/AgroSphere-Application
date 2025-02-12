package com.app.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class EmailService {
@org.springframework.beans.factory.annotation.Value("${spring.mail.username}")  // This will get the email set in application.properties
	    private String fromEmail;

	    private final JavaMailSender mailSender;

	    public EmailService(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    public void sendRegistrationEmail(String toEmail, String firstName) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(fromEmail);  // Use the dynamically loaded email from properties
	        message.setTo(toEmail);
	        message.setSubject("Registration Successful");
	        message.setText("Dear " + firstName + ",\n\n" +
	                        "Thank you for registering with us! Your account has been successfully created.\n\n" +
	                        "Best regards,\nAgrosphere Team");

	        // Send the email
	        mailSender.send(message);

	        System.out.println("Registration email sent to " + toEmail);  // Log for debugging
	    }
}
