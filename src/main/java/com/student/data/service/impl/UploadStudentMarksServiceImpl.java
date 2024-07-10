package com.student.data.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.student.data.dao.StudentMarksRepository;
import com.student.data.entity.StudentMarks;
import com.student.data.request.MarksDto;
import com.student.data.service.UploadStudentMarksService;

@Service
public class UploadStudentMarksServiceImpl implements UploadStudentMarksService {

	private final StudentMarksRepository studentMarksRepository;
	
	@Autowired
	public UploadStudentMarksServiceImpl(StudentMarksRepository studentMarksRepository) {
		this.studentMarksRepository = studentMarksRepository;
	}



	@Override
	public String uploadStudentMarks(MultipartFile file) throws IOException {
		HeaderColumnNameTranslateMappingStrategy<MarksDto> strategy = new HeaderColumnNameTranslateMappingStrategy<MarksDto>();
		strategy.setType(MarksDto.class);
		
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("id", "studentId");
		mapping.put("marks", "marks");
		
		strategy.setColumnMapping(mapping);
		
		Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CsvToBean<MarksDto> csvToBean = new CsvToBeanBuilder<MarksDto>(reader)
                                                .withMappingStrategy(strategy)
                                                .withIgnoreLeadingWhiteSpace(true)
                                                .build();
		
        List<MarksDto> studentMarksDtoList = csvToBean.parse();
        
        for(MarksDto marksDto: studentMarksDtoList) {
        	StudentMarks studentMarks = new StudentMarks();
        	studentMarks.setStudentId(marksDto.getStudentId());
        	studentMarks.setMarks(marksDto.getMarks());
        	
        	studentMarksRepository.save(studentMarks);
        }
        
        return "Students marks from csv have been dumped to db";
	}

}
