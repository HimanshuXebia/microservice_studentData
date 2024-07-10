package com.student.data.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadStudentMarksService {
	
	String uploadStudentMarks(MultipartFile file) throws IOException;
}
