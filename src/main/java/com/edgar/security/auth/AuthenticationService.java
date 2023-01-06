package com.edgar.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edgar.security.config.JwtService;
import com.edgar.security.repository.AppUserRepository;
import com.edgar.security.user.AppUser;
import com.edgar.security.user.Role;


@Service
public class AuthenticationService {
	
	@Autowired
	private AppUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private  JwtService jwtService;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = AppUser.builder()
		        .firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .role(Role.USER)
		        .build();
		repository.save(user);
	    var jwtToken = jwtService.generateToken(user);
		
	    return AuthenticationResponse.builder()
	            .token(jwtToken)
	            .build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
