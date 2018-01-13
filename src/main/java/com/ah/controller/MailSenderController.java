package com.ah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mehraj Malik
 *
 */
@RestController
public class MailSenderController {

	@Autowired
	public JavaMailSender emailSender;

	@GetMapping(path = "/send")
	public void sendSimpleMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("mehraj.malik007@gmail.com");
		message.setTo("mehrajuddin.malik@kelltontech.com");
		message.setSubject("Mail from SpringBoot");
		message.setText("Hi, there!");
		emailSender.send(message);
	}
}
