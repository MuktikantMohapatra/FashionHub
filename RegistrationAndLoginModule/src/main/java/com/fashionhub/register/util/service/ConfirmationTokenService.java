package com.fashionhub.register.util.service;

import org.springframework.stereotype.Service;

import com.fashionhub.register.util.entity.ConfirmationToken;
import com.fashionhub.register.util.entity.repository.ConfirmationTockenRepository;

@Service
public class ConfirmationTokenService {

	private ConfirmationTockenRepository tokenRepository;
	
	public boolean createEmailToken() {
		ConfirmationToken token=new ConfirmationTokenService();
		tokenRepository
		return false;
	}
}
