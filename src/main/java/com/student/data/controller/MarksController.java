package com.student.data.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.data.entity.StudentMarks;
import com.student.data.service.MarksService;

@RestController
@RequestMapping("/api/v1")
public class MarksController {
	
	private final MarksService marksService;
	
	@Autowired	
	public MarksController(MarksService marksService) {
		super();
		this.marksService = marksService;
	}

	@PostMapping("/upload-student-marks")
	ResponseEntity<String> uploadStudentMarks(@RequestParam("file") MultipartFile file) throws IOException{
		String response = marksService.uploadStudentMarks(file);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/")
	ResponseEntity<List<StudentMarks>> getStudentMarks(){
		List<StudentMarks> response = marksService.getStudentMarks();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
