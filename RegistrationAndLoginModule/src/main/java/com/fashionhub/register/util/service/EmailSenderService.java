package com.fashionhub.register.util.service;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.util.entity.ConfirmationToken;

public interface EmailSenderService {
	public void sendEmail(UserDto user,ConfirmationToken token);
}
