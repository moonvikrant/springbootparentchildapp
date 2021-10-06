package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
 
	@Autowired
	private Coursedao cdao;
	//List<Course> list;
	
	public CourseServiceImpl()
	{
		/* we are getting data from database so its commented 
		 * list=new ArrayList<>(); list.add(new Course(1211,
		 * "Java Adv","this java course " )); list.add(new Course(4241,
		 * ".Net Adv","this .net course " ));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		
		return cdao.findAll();
	}
	 
	@SuppressWarnings("deprecation")
	public Course getCourse(long courseId)
	{
		/*
		 * Course c=null; for (Course course:list) { if(course.getId()==courseId) {
		 * c=course; break; } }
		 */
		return cdao.getOne(courseId);
	
	}
	
	@Override
	public Course addCourse(Course course) 
	{
		
		//list.add(course);
		cdao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
		
		/*
		 * list.forEach(e -> { if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * });
		 */
		cdao.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) 
	{
		@SuppressWarnings("deprecation")
		Course entity=cdao.getOne(parseLong);
		
		cdao.delete(entity);
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
}
 