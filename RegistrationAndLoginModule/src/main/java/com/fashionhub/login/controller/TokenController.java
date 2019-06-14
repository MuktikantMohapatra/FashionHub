package com.fashionhub.login.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.util.service.ConfirmationTokenService;

@Controller
@RequestMapping("/verifyEmail")
public class TokenController {
	@Autowired
	private ConfirmationTokenService tokenService;

	@GetMapping
	public String validateToken(Principal principal) {
		System.out.println("TokenController.validateToken()");
		UserDto dto = new UserDto();
		dto.setEmail(principal.getName());
		tokenService.createEmailToken(dto);
		return "";
	}
}
