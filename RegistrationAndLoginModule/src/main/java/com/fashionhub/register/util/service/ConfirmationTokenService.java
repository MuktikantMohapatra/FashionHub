package com.fashionhub.register.util.service;

import com.fashionhub.register.dto.UserDto;

public interface ConfirmationTokenService {
	public boolean createEmailToken(UserDto dto);
}
