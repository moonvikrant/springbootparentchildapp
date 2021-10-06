package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired   
	private CourseService cservice;
	@GetMapping("/home")
	public String home() {
		return "this is homepage";
		
	}
	
    //get the courses 
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.cservice.getCourses();
		
	}   
	
   // get the courses with single courseid
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) 
	{
		return this.cservice.getCourse(Long.parseLong(courseId));
		
	}
	
	//add new course
	@PostMapping("/courses")
	public Course addcourse(@RequestBody Course course) 
	{
		
		return this.cservice.addCourse(course);
		
	}
	
	//update the course
	@PutMapping("/courses")
	public Course updatecourse(@RequestBody Course course) 
	{
		
		return this.cservice.updateCourse(course);
		
	}
	
	//delete the courses
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try
		{			
		this.cservice.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
	    }
	catch(Exception e)
		{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
