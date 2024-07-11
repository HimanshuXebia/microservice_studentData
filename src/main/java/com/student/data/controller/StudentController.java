package com.student.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.exception.DataApplicationException;
import com.student.data.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/merged-data")
	ResponseEntity<String> getMergedCsvFile() throws DataApplicationException{
		String response = studentService.getMergedCsvFile();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
