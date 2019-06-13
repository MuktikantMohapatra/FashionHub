package com.fashionhub.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashionhub.register.entity.AbstractEntity;

@Controller
@RequestMapping("/address")
public class AddressController extends AbstractEntity {
	@GetMapping
	public String showAddressPage() {
System.out.println("AddressController.showAddressPage()");
		return "User/address";
	}
}
