package com.pack.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.student.entity.StudentEntity;
import com.pack.student.entity.dto.StudentDto;
import com.pack.student.repository.StudentRepo;
import com.pack.student.service.StudentService;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Override
	public StudentEntity addNewStudent(StudentDto studentDto) {
		StudentEntity studentEntity = null;
		if (studentDto != null) {
			 studentEntity = convertModelToEntity(studentDto);
			studentRepo.save(studentEntity);
		
		} else {
		//	throw new UsernameNotFoundException("No Contract Data Found");
		}
		 
		return studentEntity;
	};

	private StudentEntity convertModelToEntity(StudentDto studentDto) {

		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(studentDto.getStudentId());
		studentEntity.setFirstName(studentDto.getFirstName());
		studentEntity.setLastName(studentDto.getLastName());
		studentEntity.setMobileNo(studentDto.getMobileNo());
		studentEntity.setEmailAddress(studentDto.getEmailAddress());
		//studentEntity.setUploadedPhotos(studentDto.getUploadedPhotos());
		

		return studentEntity;

	}

	@Override
	public List<StudentDto> getAll() {
		
		List<StudentEntity> studentEntity = studentRepo.findAll();

		if (studentEntity != null && !studentEntity.isEmpty()) {
			return studentEntity.stream().map(StudentImpl::convertEntityToModel).collect(Collectors.toList());
		}
		return new ArrayList<>();
		
	}

	
	  private static StudentDto convertEntityToModel(StudentEntity studentEntity) {
	  StudentDto studentdto = new StudentDto();
	  studentdto.setStudentId(studentEntity.getStudentId());
	  studentdto.setFirstName(studentEntity.getFirstName());
	  studentdto.setLastName(studentEntity.getLastName());
	  studentdto.setMobileNo(studentEntity.getMobileNo());
	  studentdto.setEmailAddress(studentEntity.getEmailAddress());
	//  studentdto.setUploadedPhotos(studentEntity.getUploadedPhotos());
	  
	  return studentdto;
	  
	  }

	@Override
	public List<StudentEntity> findByName(String name) {
		List<StudentEntity> findByNameContains=studentRepo.findByfirstNameContaining(name);
		
		return findByNameContains;
	}
	 
	
}
