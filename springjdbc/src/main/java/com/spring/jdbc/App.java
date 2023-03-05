package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entities.Student;

public class App {
    @SuppressWarnings("resource")
	public static void main( String[] args ){
        System.out.println("---------- Program starts -----------");    
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
        
        /*
        StudentDAO studentDAO = context.getBean("studentDAOImpl", StudentDAO.class);
		Student student = new Student(104, "Ravi", "Agra" );
		int numRecordAdded = studentDAO.insert(student);
		System.out.println("Student added: " + numRecordAdded);
		*/
        
        /*
        StudentDAO studentDAO = context.getBean("studentDAOImpl", StudentDAO.class);
        Student student = new Student(103, "Murli", "Kanpur");
        int numRecordUpdated = studentDAO.update(student);
		System.out.println("Student updated: " + numRecordUpdated);
		*/
        
        /*
        StudentDAO studentDAO = context.getBean("studentDAOImpl", StudentDAO.class);
        int numRecordDeleted = studentDAO.delete(103);
        System.out.println("Deleted rows: " + numRecordDeleted);
        */
        
        /*
        StudentDAO studentDAO = context.getBean("studentDAOImpl", StudentDAO.class);
        Student student = studentDAO.getStudentRecord(102);
        System.out.println(student);
        */
        
        StudentDAO studentDAO = context.getBean("studentDAOImpl", StudentDAO.class);
        List<Student> studentList = studentDAO.getAllRecords();
        for(Student s: studentList) {
        	System.out.println(s);
        }
    }
}
