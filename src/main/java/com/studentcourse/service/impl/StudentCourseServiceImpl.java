package com.studentcourse.service.impl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.studentcourse.model.Course;
import com.studentcourse.model.Student;
import com.studentcourse.service.StudentCourseInterface;

/**
 * This is a REST web service 
 * What is REST?
 * REST stands for REprsentational State Transfer. REST Specifies a set of architectural constraints. 
 * Any service which satisfies these constraints is called RESTful service. 
 * 
 * The five import constraints for RESTful web services are:
 * 1. Client - Server : There should be a service producer and a service consumer 
 * 2. The interface (URL) is uniformed and exposed resources
 * 3. The service is stateless.
 * 4. The service results should be Cacheable. HTTP cache, for example.
 * 5. Service should assume a Layered architecture. Client should not assume direct 
 * connection to server - it might be getting info from middle layer - chche.
 *  
 * @author sbehera
 *
 */
@Component
public class StudentCourseServiceImpl implements StudentCourseInterface {

	private static List<Student> students = new ArrayList<Student>();
	static{
		//Initialize Data
		Course course1 = new Course("course001","Spring","10 steps", Arrays.asList("Learn Maven", "Import Project","First Example", "Second Example"));
		Course course2 = new Course("course002","Spring MVC ","10 Examples", Arrays.asList("Learn Maven", "Import Project","First Example", "Second Example"));
		Course course3 = new Course("course003","Spring Boot ","6k Student", Arrays.asList("Learn Maven", "Import Project","First Example", "Second Example"));
		Course course4 = new Course("course004","Maven","Most Popular Course", Arrays.asList("Learn Maven", "Import Project","First Example", "Second Example"));
		Course course5 = new Course("course004","Sprint REST","Most Popular REST", Arrays.asList("Learn Maven", "Import Project","First Example", "Second Example"));
		
		Student ram = new Student("Ram Charan", "student001", "Programmer and Developer", new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5)));
		Student krishna = new Student("Krishna", "student002", "Lead Developer", new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5)));
		Student gopal = new Student("Gopal", "student003", "Software Developer", new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5)));
		Student hari = new Student("Hari", "student004", "Tester", new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5)));
		Student ganesh = new Student("Ganesh", "student005", "Dev. Manager", new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5)));
		
		students.add(ram);
		students.add(krishna);
		students.add(gopal);
		students.add(hari);
		students.add(ganesh);
	}
	
	public List<Student> retrieveAllStudents() {
		return students;
	}

	public Student retrieveStudent(String studentId) {
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	public Course retrieveCourse(String studentId, String courseId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getCourseId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}	
	/**
	 * 
	 */
	private SecureRandom random = new SecureRandom();

	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		course.setCourseId(randomId);

		student.getCourses().add(course);

		return course;
	}
	
	/**
	 * Deleting student based on id
	 * 
	 */
	public void deleteStudent(String studentId){

		Student student = retrieveStudent(studentId);

		if (student == null) {
			return;
		}
		
		students.remove(student);		
	}
}
