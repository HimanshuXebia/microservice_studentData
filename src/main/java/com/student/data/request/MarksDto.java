package com.student.data.request;

import com.opencsv.bean.CsvBindByPosition;

public class MarksDto {

	@CsvBindByPosition(position = 0)
	private Long studentId;
	@CsvBindByPosition(position = 0)
	private int marks;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
