package com.fashionhub.register.util.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import com.fashionhub.register.dto.UserDto;

public class EmailSenderServiceImpl implements EmailSenderService {
	@Async
	@Override
	public void sendEmail(UserDto user) {
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
         mailMessage.setTo(user.getEmail());
         mailMessage.setSubject("Complete Registration!");
         mailMessage.setFrom("chand312902@gmail.com");
         mailMessage.setText("To confirm your account, please click here : "
         +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());

	}

}
