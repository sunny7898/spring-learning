package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Student student) {
		String query = "insert into student values (?, ?, ?)";
		int numRecordsAdded = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return numRecordsAdded;
	}
	public int update(Student student) {
		String query = "Update Student set name=?, city=? where id = ?";
		int numRecordUpdated = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return numRecordUpdated;
	}
	public int delete(int studentId) {
		String query = "Delete from Student where id=?";
		int numRecordDeleted = this.jdbcTemplate.update(query, studentId);
		return numRecordDeleted;
	}
	// Selecting single student record
	public Student getStudentRecord(int studentId) {
		String query = "Select * from Student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	
	// Selecting multiple records
	public List<Student> getAllRecords() {
		String query = "Select * from Student";
		List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperImpl());
		return studentList;
	}
}
