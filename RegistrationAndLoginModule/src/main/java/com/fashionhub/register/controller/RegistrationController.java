package com.fashionhub.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	

	@GetMapping
	public String showPage() {
		return "/Registration/registration";
	}

	@PostMapping
	public String registerUser(@ModelAttribute UserDto userDto, Model model,HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("User details ::::::::::" + userDto);
			registrationService.saveUser(userDto);
			registrationService.autoLogin(userDto, request);
			return "User/userDashBoard";
		} catch (Exception e) {
			model.addAttribute("", "fix errors");
			e.printStackTrace();
			return "/Registration/registration";
		}

	}

	

}
