package com.studentcourse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentcourse.model.Student;
import com.studentcourse.service.StudentCourseInterface;

@Controller
public class WelcomePageController {
	
	@Autowired
	public StudentCourseInterface studentCourseServiceInterface;
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String welcomeMessage(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="all-students")
	public String retriveAllStudents(HttpServletRequest request){
	
		List<Student> students = studentCourseServiceInterface.retrieveAllStudents();
		
		students.forEach(student -> System.out.println(student.getCourses().get(0)));
		students.forEach(student -> System.out.println(student.getDescription()));
		
		request.setAttribute("studentDetails", students);
		request.setAttribute("mode", "MODE_SPRING_MVC");
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="update-task")
	public String updateTask(@RequestParam int studentId, HttpServletRequest request){
		//request.setAttribute("studentDetails", studentCourseServiceInterface.updateStudent(studentId));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="delete-task")
	public String deleteTask(@RequestParam String studentId, HttpServletRequest request){
		studentCourseServiceInterface.deleteStudent(studentId);
		request.setAttribute("studentDetails", studentCourseServiceInterface.retrieveAllStudents());
		request.setAttribute("mode", "MODE_SPRING_MVC");
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="spring-security")
	public String springSecurity(HttpServletRequest request){
		request.setAttribute("mode", "MODE_SPRING_SECURITY");
		return "index";
	}
	
}
