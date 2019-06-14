package com.fashionhub.register.util.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailSenderService {
	public void sendEmail(SimpleMailMessage mail);
}
