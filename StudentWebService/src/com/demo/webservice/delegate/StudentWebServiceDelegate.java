package com.demo.webservice.delegate;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.demo.data.Student;
import com.demo.webservice.StudentWebService;
/**
 * This is the delegate for Student  Web Service.
 * 
 * @author Damodar Yemme
 */
@WebService(serviceName="StudentWebService", portName="StudentWebServicePort", targetNamespace="http://service.student.demo.com/")
public class StudentWebServiceDelegate extends SpringBeanAutowiringSupport {
	@Autowired
	private StudentWebService studentWebService;

	/**
	 * Default constructor.
	 */
	public StudentWebServiceDelegate() {
		super();
	}

	/**
	 * This method returns an active student.
	 * 
	 * @param studentID of a student.
	 * @return a <code>Student</code> object.
	 */
	@WebResult(name="student")
	@WebMethod( action="getStudent")
	public Student getStudent(
		@WebParam(name="studentID", targetNamespace="http://service.student.demo.com/")final Long studentID) throws WebServiceException {
		try{
			return this.studentWebService.getStudent(studentID);
		}
		catch(Exception ex) {
			throw new WebServiceException(ex);
		}			
	}
	/**
	 * This method returns an active student.
	 * 
	 * @param studentID of a student.
	 * @return a <code>Student</code> object.
	 */
	//@WebResult(name="students")
	@WebResult(name="students")
	@WebMethod( action="getStudentByName")
	public Collection<Student> getStudentByName(
		@WebParam(name="studentName", targetNamespace="http://service.student.demo.com/")final String studentName) throws WebServiceException {
		try{			
			return this.studentWebService.getStudentByName(studentName);
		}
		catch(Exception ex) {
			throw new WebServiceException(ex);
		}			
	}	
	/**
	 * This method adds a student to database.
	 * 
	 * @param student Object of a student.
	 * @return a <code>Status</code> of operation.
	 */
	@WebResult(name="result")
	@WebMethod( action="addStudentToDB")
	public String addStudentToDB(
		@WebParam(name="studentFName", targetNamespace="http://service.student.demo.com/")final String studentFName,
		@WebParam(name="studentLName", targetNamespace="http://service.student.demo.com/")final String studentLName,
		@WebParam(name="studentMName", targetNamespace="http://service.student.demo.com/")final String studentMName
		) throws WebServiceException {
		try{
			Student student = new Student();
			student.setFirstName(studentFName);
			student.setLastName(studentLName);
			student.setMiddleName(studentMName);
			return this.studentWebService.addStudent(student);
		}
		catch(Exception ex) {
			throw new WebServiceException(ex);
		}			
	}
	/**
	 * This method updates a student.
	 * 
	 * @param student Object of a student.
	 * @return a <code>Status</code> of operation.
	 */
	@WebResult(name="result")
	@WebMethod( action="updateStudent")
	public String updateStudent(
			@WebParam(name="studentFName", targetNamespace="http://service.student.demo.com/")final String studentFName,
			@WebParam(name="studentLName", targetNamespace="http://service.student.demo.com/")final String studentLName,
			@WebParam(name="studentMName", targetNamespace="http://service.student.demo.com/")final String studentMName,
			@WebParam(name="studentID", targetNamespace="http://service.student.demo.com/")final Long studentID
			) throws WebServiceException {
		try{
			Student student = new Student();
			student.setFirstName(studentFName);
			student.setLastName(studentLName);
			student.setMiddleName(studentMName);
			student.setStudentID(studentID);
			return this.studentWebService.updateStudent(student);
		}
		catch(Exception ex) {
			throw new WebServiceException(ex);
		}
	}
		/**
		 * This method deletes a student from database.
		 * 
		 * @param student Object of a student.
		 * @return a <code>Status</code> of operation.
		 */
		@WebResult(name="result")
		@WebMethod( action="deleteStudent")
		public String deleteStudent(
			@WebParam(name="studentID", targetNamespace="http://service.student.demo.com/")final Long studentID) throws WebServiceException {
			try{
				return this.studentWebService.deleteStudent(studentID);
			}
			catch(Exception ex) {
				throw new WebServiceException(ex);
			}		
	}
}
