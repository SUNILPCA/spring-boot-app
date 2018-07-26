package com.studentcourse.controller;

import io.swagger.annotations.Api;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.studentcourse.model.Course;
import com.studentcourse.model.Student;
import com.studentcourse.service.StudentCourseInterface;

@RestController
@Api(value="StudentCourseControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentCourseController {

	private final Logger log = LoggerFactory.getLogger(StudentCourseController.class);
	
	@Autowired
	public StudentCourseInterface studentCourseServiceInterface;			
	
	@RequestMapping(method = RequestMethod.GET, value="api/students")
	public List<Student> retriveAllStudents(){
		
		log.info("In side the all students method:::");
		/*List<Student> students = studentCourseServiceInterface.retrieveAllStudents();
		students.forEach(student -> System.out.println(student.getCourses().get(0)));
		students.forEach(student -> System.out.println(student.getDescription()));*/
		
		return studentCourseServiceInterface.retrieveAllStudents();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="api/students/{studentId}/courses")
	public Student retriveStudent(@PathVariable String studentId){
		
		Student student = studentCourseServiceInterface.retrieveStudent(studentId);
		log.info(student.getDescription());
		
		return studentCourseServiceInterface.retrieveStudent(studentId);
	}
		
	
	@GetMapping("api/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		
		return studentCourseServiceInterface.retrieveCourse(studentId, courseId);
	}
	
	@PostMapping("api/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable String studentId, @RequestBody Course newCourse) {

		Course course = studentCourseServiceInterface.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getCourseId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="api/delete-task")
	public Student deleteTask(@RequestParam String studentId, HttpServletRequest request){
		studentCourseServiceInterface.deleteStudent(studentId);
		
		return studentCourseServiceInterface.retrieveStudent(studentId);
	}
}
