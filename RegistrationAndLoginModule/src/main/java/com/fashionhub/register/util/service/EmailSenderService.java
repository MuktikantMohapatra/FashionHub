package com.fashionhub.register.util.service;

import com.fashionhub.register.dto.UserDto;

public interface EmailSenderService {
	public void sendEmail(UserDto user);
}
