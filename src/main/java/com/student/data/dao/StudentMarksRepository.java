package com.student.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.data.entity.StudentMarks;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {
	
	StudentMarks findByStudentId(Long studentId);

}
