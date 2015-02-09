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
	 * @param studentID of a student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Student getStudent(Long studentID) {		
		return this.studentService.getStudent(studentID);
	}
	/**
	 * This method returns a students based on student name.
	 * 
	 * @param studentID ID of a student.
	 * @return a <Collection>Student</Collection> object.
	 */
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Collection<Student> getStudentByName(String studentName) {		
		return this.studentService.getStudent(studentName);
	}
	/**
	 * This method adds a student to database.
	 * 
	 * @param student object of student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public String addStudent(Student student) {
		return this.studentService.addStudent(student);
	}
	/**
	 * This method updates a student.
	 * 
	 * @param student object of student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public String updateStudent(Student student) {
		return this.studentService.updateStudent(student);
	}
	/**
	 * This method deletes a student.
	 * 
	 * @param student object of student.
	 * @return a <code>Student</code> object.
	 */
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public String deleteStudent(Long studentID) {
		return this.studentService.deleteStudent(studentID);
	}
}
