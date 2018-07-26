package com.studentcourse.service;

import java.util.List;

import com.studentcourse.model.Course;
import com.studentcourse.model.Student;


public interface StudentCourseInterface {
	
	public List<Student> retrieveAllStudents();
	public Student retrieveStudent(String studentId);
	public List<Course> retrieveCourses(String studentId);
	public Course retrieveCourse(String studentId, String courseId);
	public Course addCourse(String courseId, Course course);
	public void deleteStudent(String studentId);
}
