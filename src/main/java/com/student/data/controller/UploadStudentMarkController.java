package com.student.data.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.data.service.UploadStudentMarksService;

@RestController
@RequestMapping("/api/v1")
public class UploadStudentMarkController {
	
	private final UploadStudentMarksService uploadStudentMarksService;
	
	@Autowired	
	public UploadStudentMarkController(UploadStudentMarksService uploadStudentMarksService) {
		super();
		this.uploadStudentMarksService = uploadStudentMarksService;
	}



	@PostMapping("/upload-student-marks")
	ResponseEntity<String> uploadStudentMarks(@RequestParam("file") MultipartFile file) throws IOException{
		String response = uploadStudentMarksService.uploadStudentMarks(file);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	

}
