package com.pack.student.security.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		if(username.equals("Farid"))
		{
			return new User("Farid", "Farid123", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found !!..");
		}
		
		 
	}

}
