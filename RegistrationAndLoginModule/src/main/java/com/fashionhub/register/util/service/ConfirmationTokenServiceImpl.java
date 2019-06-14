package com.fashionhub.register.util.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.entity.UserEntity;
import com.fashionhub.register.repository.UserRepository;
import com.fashionhub.register.util.entity.ConfirmationToken;
import com.fashionhub.register.util.entity.repository.ConfirmationTockenRepository;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ConfirmationTockenRepository tokenRepository;

	@Autowired
	private EmailSenderService emailService;

	@Autowired
	public boolean createEmailToken(UserDto dto) {
		System.out.println("ConfirmationTokenServiceImpl.createEmailToken()");
		UserEntity user = userRepository.findByEmail(dto.getEmail());
		ConfirmationToken token = new ConfirmationToken(user);
		ConfirmationToken savedToken = tokenRepository.save(token);
		if (savedToken != null) {
			emailService.sendEmail(dto, savedToken);
		}
		return false;
	}
}
