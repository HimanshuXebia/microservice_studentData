package com.student.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.data.dao.StudentMarksRepository;
import com.student.data.dao.StudentRepository;
import com.student.data.entity.Student;
import com.student.data.entity.StudentMarks;
import com.student.data.exception.DataApplicationException;
import com.student.data.request.StudentDto;
import com.student.data.response.StudentListResponse;
import com.student.data.service.MarksService;
import com.student.data.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private final RestTemplate restTemplate;
	private final MarksService marksService;
	private final StudentMarksRepository studentMarksRepository;
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(RestTemplate restTemplate, MarksService marksService, StudentMarksRepository studentMarksRepository, StudentRepository studentRepository) {
		this.restTemplate = restTemplate;
		this.marksService = marksService;
		this.studentMarksRepository = studentMarksRepository;
		this.studentRepository = studentRepository;
	}
	
	@Value("${student.csvParser.url}")
	private String studentsRecords;


	@Override
	public String getMergedCsvFile() throws DataApplicationException {
		// TODO Auto-generated method stub
		ResponseEntity<StudentListResponse> response = restTemplate.exchange(studentsRecords, HttpMethod.GET, null, StudentListResponse.class);
		if(!response.getStatusCode().is2xxSuccessful()) {
			throw new DataApplicationException(HttpStatus.NOT_FOUND, "CSV microservice is not working");
		}
		StudentListResponse studentListResponse = response.getBody();
		List<StudentDto> students = studentListResponse != null ? studentListResponse.getstudentList() : new ArrayList<>();
		System.out.println("response to be printed: " + students.size());
		
		for(StudentDto studentDto: students) {
			StudentMarks marks = studentMarksRepository.findByStudentId(studentDto.getStudentId());
			Student student = new Student();
			student.setStudentId(studentDto.getStudentId());
			student.setName(studentDto.getName());
			student.setDept(studentDto.getDept());
			student.setAddress(studentDto.getAddress());
			student.setPhoneNumber(studentDto.getPhoneNumber());
			student.setMarks(marks.getMarks());
			
			studentRepository.save(student);
		}
		
		return "Data have been merged!";
	}

}
