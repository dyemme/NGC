package com.demo.webservice;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.data.Student;
import com.demo.service.StudentService;

/**
 * Class implementing student service operations.
 * 
 * @author Damodar Yemme
 */
@Transactional
@Service
public class StudentWebService {

	/** Class scope logging instance. */
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(StudentWebService.class);
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * Default constructor.
	 */
	public StudentWebService() {
		super();
	}	
	/**
	 * This method returns a student based on student ID.
	 * 
	 * @param studentID ID of an student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Student getStudent(Long studentID) {
		return this.studentService.getStudent(studentID);
	}
	/**
	 * This method returns a student based on student ID.
	 * 
	 * @param studentID ID of an student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Collection<Student> getStudentByName(String studentName) {
		return this.studentService.getStudent(studentName);
	}
}
