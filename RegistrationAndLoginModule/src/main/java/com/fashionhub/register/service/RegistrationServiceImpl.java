package com.fashionhub.register.service;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.fashionhub.register.dto.AddressDto;
import com.fashionhub.register.dto.UserDto;
import com.fashionhub.register.entity.AddressEntity;
import com.fashionhub.register.entity.RoleEntity;
import com.fashionhub.register.entity.UserEntity;
import com.fashionhub.register.repository.AddressRepository;
import com.fashionhub.register.repository.RoleRepository;
import com.fashionhub.register.repository.UserRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	protected AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean saveUser(UserDto userDto) {
		Set<RoleEntity> role = new HashSet<>();
		RoleEntity defaultRole = roleRepository.findAllByName("USER");
		role.add(defaultRole);
		UserEntity user = new UserEntity();
		user.setName(userDto.getName());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setDob(userDto.getDob());
		user.setPassword(encoder.encode(userDto.getPassword()));
		user.setRoles(role);
		UserEntity saveUser = userRepository.save(user);
		if (saveUser == null) {
			return false;
		} else {

			return true;
		}

	}

	@Override
	public boolean saveAddress(AddressDto addressDto) {
		AddressEntity address = new AddressEntity();
		address.setFlatno(addressDto.getFlatno());
		address.setStreet(addressDto.getStreet());
		address.setLandmark(addressDto.getLandmark());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		AddressEntity saveAddress = addressRepository.save(address);
		if (saveAddress == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void autoLogin(UserDto user, HttpServletRequest request) {
		UserEntity user1 = userRepository.findByEmail(user.getEmail());
		System.out.println(user1);
		String username = user.getEmail();
		String password = user.getPassword();
		User user3 = new User(username, password, user1.getRoles());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user3.getUsername(),
				user3.getPassword());
		request.getSession();
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

	}

}
