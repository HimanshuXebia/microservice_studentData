package com.student.data.service;

import com.student.data.exception.DataApplicationException;

public interface StudentService {
	
	String getMergedCsvFile() throws DataApplicationException;

}
