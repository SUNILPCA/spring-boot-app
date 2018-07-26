package com.studentcourse.model;

import java.util.List;

public class Student {
	
	private String studentId;
	private String studentName;
	private String description;
	private List<Course> courses;
	
	public Student(String name, String id, String desc, List<Course> courses){
		this.studentName = name;
		this.studentId = id;
		this.description = desc;
		this.courses = courses;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCoures(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
