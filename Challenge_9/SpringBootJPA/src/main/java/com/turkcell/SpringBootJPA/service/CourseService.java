package com.turkcell.SpringBootJPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootJPA.model.Course;
import com.turkcell.SpringBootJPA.model.CourseDTO;
import com.turkcell.SpringBootJPA.repository.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

	private CourseRepository courseRepository;
	
	public List<Course> getAll(){
		return courseRepository.findAll();
	}
	
	public List<CourseDTO> getAllDTO(){
		List<Course> courses = courseRepository.findAll();
		List<CourseDTO> courseDTO = new ArrayList<CourseDTO>();
		for (Course course : courses) {
			CourseDTO listcourseDTO = new CourseDTO();
			listcourseDTO.setCourseName(course.getCourseName());
			listcourseDTO.setSubject(course.getSubject());
			listcourseDTO.setTeacher(course.getTeacher());
			
			courseDTO.add(listcourseDTO);
		}
		return courseDTO;
	}
	public Course getById(long id) {
		return courseRepository.findById(id).orElse(null);
	}
	
	public Course courseAdd(Course course) {
		return courseRepository.save(course);	
	}
	
	public void deleteCourse(long id) {
		courseRepository.deleteById(id);
	}
}
