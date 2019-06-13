package com.fashionhub.register.util.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fashionhub.register.util.entity.ConfirmationToken;

public interface ConfirmationTockenRepository extends JpaRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
