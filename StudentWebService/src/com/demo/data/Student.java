package com.demo.data;

import java.io.Serializable;

public class Student implements Serializable{
	
	 /** Serial version UID. */
	 
	private static final long serialVersionUID = 1L;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The middle name. */
	private String middleName;
	
	/** The student ID. */
	private Long studentID;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the studentID
	 */
	public Long getStudentID() {
		return this.studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
}
