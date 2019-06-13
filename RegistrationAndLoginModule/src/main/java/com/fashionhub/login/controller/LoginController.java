package com.fashionhub.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionhub.login.security.service.SecurityService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private SecurityService securityService;

	@GetMapping
	public String showLoginPage() {
		return "Login/login";
	}

	@PostMapping
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		System.out.println("LoginController.login()");
		try {
			boolean loginResponse = securityService.validateUser(email, password);
			System.out.println(loginResponse);
			if (loginResponse) {
				return "User/userDashBoard";
			} else {
				model.addAttribute("msg", "User Name or Password is invalid.Try again..");
				return "Login/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "User Name or Password is invalid.Try again..");
			return "Login/login";
		}

	}

}
