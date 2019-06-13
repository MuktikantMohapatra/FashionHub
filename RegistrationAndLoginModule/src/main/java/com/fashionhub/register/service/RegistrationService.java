package com.fashionhub.register.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fashionhub.register.dto.AddressDto;
import com.fashionhub.register.dto.UserDto;

@Service
public interface RegistrationService {
	public boolean saveUser(UserDto userDto);
	public void autoLogin(UserDto user, HttpServletRequest request); 
	public boolean saveAddress(AddressDto addressDto);
}
