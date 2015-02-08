package com.demo.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.StudentDAO;
import com.demo.data.Student;
/**
 * Service operations and business logic for student related functionality.
 * 
 * @author Damodar Yemme.
 */
@Service
@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_UNCOMMITTED)
public class StudentService {
	/** Class scope logging instance. */
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(StudentService.class);
	
	@Autowired
	private StudentDAO studentDAO;
	/**
	 * Default constructor.
	 */
	public StudentService() {
		super();
	}
	/**
	 * This method returns a student based on the input student ID.
	 * 
	 * @param studentID ID of a student.
	 * @return a <code>Student</code> object.
	 */
	public Student getStudent(Long studentID) {
		return this.studentDAO.getStudent(studentID);		
		//return this.studentDAO.getUniqueStudent(studentID);
	}
	/**
	 * This method returns a student based on the input student Name.
	 * 
	 * @param studentName of a student.
	 * @return a <code>Student</code> object.
	 */
	public Collection<Student> getStudent(String studentName) {
		return this.studentDAO.getStudent(studentName);				
	}	
	/**
	 * This method adds a student database.
	 * 
	 * @param Student of a student.
	 * @return a <code>status</code> of operation.
	 */
	public String addStudent(Student student) {
		return this.studentDAO.addStudent(student);		
	}
	/**
	 * This method deletes a student from database.
	 * 
	 * @param Student of a student.
	 * @return a <code>status</code> of operation.
	 */
	public String deleteStudent(Long studentID) {
		return this.studentDAO.deleteStudent(studentID);		
	}
	/**
	 * This method deletes a student from database.
	 * 
	 * @param Student of a student.
	 * @return a <code>status</code> of operation.
	 */
	public String updateStudent(Student student) {
		return this.studentDAO.updateStudent(student);		
	}
}
