package com.pack.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.student.project.entity.StudentProject;

public interface ProjectRepo  extends JpaRepository<StudentProject, Integer> {

}
