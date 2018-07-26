package com.studentcourse.model;

import java.util.List;

public class Course {

	private String courseId;
	private String courseName;
	private String description;
	private List<String> steps;
	
	
	public Course(){
		
	}
	
	public Course(String id, String name, String desc, List<String> stepsList){
		
		this.courseId = id;
		this.courseName = name;
		this.description = desc;
		this.steps = stepsList;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
}
