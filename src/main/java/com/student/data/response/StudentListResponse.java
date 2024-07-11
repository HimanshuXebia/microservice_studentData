package com.student.data.response;

import java.util.List;

import com.student.data.request.StudentDto;

public class StudentListResponse {
	
	private List<StudentDto> studentList;

    public List<StudentDto> getstudentList() {
        return studentList;
    }

    public void setstudentList(List<StudentDto> studentList) {
        this.studentList = studentList;
    }
}
