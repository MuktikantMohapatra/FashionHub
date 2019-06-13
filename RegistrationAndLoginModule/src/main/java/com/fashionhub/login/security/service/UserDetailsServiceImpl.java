package com.fashionhub.login.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fashionhub.register.entity.UserEntity;
import com.fashionhub.register.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity validatingUser = userRepository.findByEmail(email);
		if (validatingUser == null) {
			throw new UsernameNotFoundException("User Not found with the email :" + email);
		}
		return new User(validatingUser.getEmail(), validatingUser.getPassword(), validatingUser.getRoles());
	}

}
