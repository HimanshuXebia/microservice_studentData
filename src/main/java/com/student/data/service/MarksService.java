package com.student.data.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.student.data.entity.StudentMarks;

public interface MarksService {
	
	String uploadStudentMarks(MultipartFile file) throws IOException;

	List<StudentMarks> getStudentMarks();
}
