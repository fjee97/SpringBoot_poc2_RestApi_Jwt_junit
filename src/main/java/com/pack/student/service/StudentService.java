package com.pack.student.service;

import java.util.List;

import com.pack.student.entity.StudentEntity;
import com.pack.student.entity.dto.StudentDto;

public interface StudentService {
StudentEntity addNewStudent (StudentDto studentDto);
List<StudentDto> getAll();
public List<StudentEntity> findByName(String name);


}
