
package com.pack.student.jwtcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pack.student.security.service.CustomeUserDetailService;
import com.pack.student.token_generator.TokenGenerator;
import com.pack.student.token_generator.model.JwtRequest;
import com.pack.student.token_generator.model.JwtResponse;

@RestController
public class JwtTokenGeneratorController {

	@Autowired
	private CustomeUserDetailService CustomeUserDetailService;
	@Autowired
	private TokenGenerator tokenGenerator;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping( value="/token", method = RequestMethod.POST)
	public ResponseEntity<?> genertorToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
		 e.printStackTrace();
		 throw new Exception("Bad Credentials");
		}catch (BadCredentialsException e) {
			 e.printStackTrace();
			 throw new Exception("Bad Credentials");
		}
		
		
		UserDetails userDetails = this.CustomeUserDetailService.loadUserByUsername(jwtRequest.getUserName());
		
		String token = this.tokenGenerator.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
}
