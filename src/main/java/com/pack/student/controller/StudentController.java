package com.pack.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pack.student.entity.StudentEntity;
import com.pack.student.entity.dto.StudentDto;
import com.pack.student.repository.ProjectRepo;
import com.pack.student.repository.StudentRepo;
import com.pack.student.serviceimpl.StudentImpl;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentImpl service;

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ProjectRepo projectRepo;

	@PostMapping("/reg")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity studentEntity,
			@RequestParam("uploadedPhotos") MultipartFile file) {
		// System.out.println(studentProject);
		System.out.println(file.getOriginalFilename());
		System.out.println(studentEntity);
		StudentEntity studentEntities = studentRepo.save(studentEntity);

		return new ResponseEntity<StudentEntity>(studentEntities, HttpStatus.OK);

	}

	// http://localhost:8080/api
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAll() {
		List<StudentDto> list = service.getAll();

		return new ResponseEntity<List<StudentDto>>(list, HttpStatus.OK);

	}

	// http://localhost:8080/api/find?findname=findByName&details=f
	@GetMapping("/find")
	public ResponseEntity<List<StudentEntity>> findStudentbyName(@RequestParam("findname") String findDetails,
			@RequestParam("details") String name) {
		if (findDetails.equals("findByName")) {
			List<StudentEntity> find = service.findByName(name);
			return new ResponseEntity<List<StudentEntity>>(find, HttpStatus.OK);
		}

		return new ResponseEntity<List<StudentEntity>>(HttpStatus.NOT_FOUND);

	}

}
