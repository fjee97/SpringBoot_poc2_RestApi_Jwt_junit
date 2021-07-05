package com.pack.student.project.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pack.student.entity.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentproject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// private String projId;
	private Integer projId;
	private String projname;
	private String projDuration;

	@ManyToOne(fetch = FetchType.LAZY)

	private StudentEntity studentEntity;

}
