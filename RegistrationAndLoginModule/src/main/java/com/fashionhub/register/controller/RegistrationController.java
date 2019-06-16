package com.fashionhub.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.service.RegistrationService;
import com.fashionhub.register.util.service.TokenConfirmation;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private TokenConfirmation tokenConfirmation;

	@GetMapping
	public String showPage() {
		return "/Registration/registration";
	}

	@PostMapping
	public String registerUser(@ModelAttribute UserDto userDto, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("User details ::::::::::" + userDto);
		boolean result = registrationService.saveUser(userDto);
		if (result == true) {
			// registrationService.autoLogin(userDto, request);
			return "Registration/message";
		} else
			return "/Registration/registration";
	}

	@GetMapping(value = "/confirm-account")
	public String verifyToken(@RequestParam("token") String token) {
		System.out.println("RegistrationController.verifyToken()");
		boolean verifyToken = tokenConfirmation.verifyToken(token);
		if (verifyToken == false) {
			return "/Registration/registration";
		} else
			return "/User/userDashBoard";
	}
}
