package com.pack.student.entity.dto;

import lombok.Data;

@Data
/*
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */
public class StudentDto {
	
	//private String studentId;
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailAddress;
	private String uploadedPhotos;
	
	

}
