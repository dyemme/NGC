package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.data.Student;

/**
 * Class implementing data operations relative to the student table or logical entity.
 */
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class StudentDAO{

	/** Class scope logging instance. */
	private final static Logger logger = Logger.getLogger(StudentDAO.class);
	public static Connection connection = null;
	/**
	 * Default constructor.
	 */
	public StudentDAO() {
		;
	}	
	public static Connection getConnection(){
		
		connection = null;		 
		try {
 
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student", "postgres",
					"postgres");
 
		} catch (SQLException e) { 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace(); 
		}
		return connection;
	}
	/**
	 * This method returns a student based on the input student ID.
	 * 
	 * @param studentID ID of a student.
	 * @return a <code>Student</code> object.
	 */
	public Student getStudent(Long studentID) {
		Student student = new Student();
		Statement stmt = null;
		ResultSet rs = null;
		if (studentID == null)  { return null; }
		try{
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery("SELECT * FROM student where student_id= "+studentID);
			while (rs.next()) {
				student.setStudentID(Long.parseLong(rs.getString("student_id")));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMiddleName(rs.getString("middle_name"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		} finally {			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return student;
	}	
	/**
	 * This method returns a student based on the input student Name.
	 * 
	 * @param studentName of a student.
	 * @return a <code>Student</code> object.
	 */
	public Collection<Student> getStudent(String studentName) {
		Collection<Student> students = new ArrayList<Student>();		
		Statement stmt = null;
		ResultSet rs = null;
		if (studentName == null)  { return null; }
		try{
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery("SELECT * FROM student where first_name like '"+studentName+"%' or last_name like '"+studentName+"%'");
			while (rs.next()) {
				Student student = new Student();
				student.setStudentID(Long.parseLong(rs.getString("student_id")));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMiddleName(rs.getString("middle_name"));	
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		} finally {			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
			
		}
		return students;
	}	

}
