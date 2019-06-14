package com.fashionhub.register.util.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionhub.register.util.entity.ConfirmationToken;
@Repository
public interface ConfirmationTockenRepository extends JpaRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
