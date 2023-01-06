package com.edgar.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.edgar.security.repository.AppUserRepository;
import com.edgar.security.user.AppUser;
import com.edgar.security.user.AppUserBuilder;

@Service
public class AuthenticationService {
	
	@Autowired
	AppUserRepository repository;

	public AuthenticationResponse register(RegisterRequest request) {
			var user = AppUserBuilder.build()
					.firstname(request.getFirstname())
					.lastname(request.getLastname())
					.email
					
					.build();
		return null;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
