package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDAO {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int studentId);
	public Student getStudentRecord(int studentId);
	public List<Student> getAllRecords();
}
