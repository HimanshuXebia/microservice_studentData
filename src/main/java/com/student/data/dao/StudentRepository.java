package com.student.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.data.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
