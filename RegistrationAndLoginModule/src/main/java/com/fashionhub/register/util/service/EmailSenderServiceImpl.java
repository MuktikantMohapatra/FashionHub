package com.fashionhub.register.util.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.util.entity.ConfirmationToken;
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	@Async
	@Override
	public void sendEmail(UserDto user, ConfirmationToken token) {
		System.out.println("EmailSenderServiceImpl.sendEmail()");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom("chand312902@gmail.com");
		mailMessage.setText("To confirm your account, please click here : "
				+ "http://localhost:8082/confirm-account?token=" + token.getConfirmationToken());

	}

}
