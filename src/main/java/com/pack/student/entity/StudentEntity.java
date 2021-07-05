package com.pack.student.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pack.student.project.entity.StudentProject;

import lombok.Data;

@Entity
@Table(name = "student")
 @Data
public class StudentEntity {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	
	//private String studentId;
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailAddress;
	private String uploadedPhotos;
	@Transient
	private  Byte[] base64;
	
	
	  @OneToMany(mappedBy = "studentEntity",cascade = CascadeType.ALL)
	  @JsonManagedReference
	  private List<StudentProject> studentProjects;
	 

}
