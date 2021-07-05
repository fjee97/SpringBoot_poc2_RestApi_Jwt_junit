package com.pack.student.unit_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.pack.student.entity.dto.StudentDto;
import com.pack.student.repository.StudentRepo;
import com.pack.student.serviceimpl.StudentImpl;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class StudentTesting {

	@InjectMocks
	private StudentImpl student;
	
	@Mock
	StudentRepo repo;
	
	@Test
	public void test() {
		student.addNewStudent(new StudentDto());
		student.findByName("xyz");
		student.getAll();
		
	}
}
