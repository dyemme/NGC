package com.demo.webservice.delegate;

import java.util.Collection;

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
	@WebResult(name="student", targetNamespace="http://service.student.demo.com/")
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
	@WebResult(name="students", targetNamespace="http://service.student.demo.com/")
	public Collection<Student> getStudentByName(
		@WebParam(name="studentName", targetNamespace="http://service.student.demo.com/")final String studentName) throws WebServiceException {
		try{
			return this.studentWebService.getStudentByName(studentName);
		}
		catch(Exception ex) {
			throw new WebServiceException(ex);
		}			
	}
}
