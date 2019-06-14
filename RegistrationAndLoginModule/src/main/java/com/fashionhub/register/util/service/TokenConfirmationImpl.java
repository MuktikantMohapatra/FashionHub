package com.fashionhub.register.util.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionhub.register.entity.UserEntity;
import com.fashionhub.register.repository.UserRepository;
import com.fashionhub.register.util.entity.ConfirmationToken;
import com.fashionhub.register.util.entity.repository.ConfirmationTockenRepository;

@Service
public class TokenConfirmationImpl implements TokenConfirmation {
	@Autowired
	private ConfirmationTockenRepository tokenRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean verifyToken(String token) {
		ConfirmationToken confirmationToken = tokenRepository.findByConfirmationToken(token);
		if (confirmationToken != null) {
			UserEntity user = userRepository.findByEmail(confirmationToken.getUser().getEmail());
			user.setEnabled(true);
			return true;
		}

		return false;
	}

}
