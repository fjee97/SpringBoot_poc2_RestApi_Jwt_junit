package com.pack.student.jwtcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		String text="This API Using Spring Boot";
		text+="This page is not allowed to access";
		
		return text;
	}

}
