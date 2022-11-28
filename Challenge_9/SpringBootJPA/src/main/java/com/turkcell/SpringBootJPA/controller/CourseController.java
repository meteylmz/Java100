package com.turkcell.SpringBootJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootJPA.model.Course;
import com.turkcell.SpringBootJPA.model.CourseDTO;
import com.turkcell.SpringBootJPA.service.CourseService;

@RestController
@RequestMapping(value = "course")
public class CourseController {

	@Autowired
	public CourseService courseService;
	
	@GetMapping(path="getAll")
	public List<Course> getAll(){
		List<Course> list = courseService.getAll();
		return list;
	}
	
	@GetMapping(path = "getAllDTO",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CourseDTO> getAllDTO(){
		List<CourseDTO> list = courseService.getAllDTO();
		return list;
	}
	
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.getById(id));
	}
	
	@PostMapping(path = "Add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> Add(@RequestBody Course course){
		course = courseService.courseAdd(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(course.getCourseName() + " isimli ders eklendi!");
	}
	
	@DeleteMapping(path = "Delete")
	public ResponseEntity<String> Delete(@RequestBody Course course){
		courseService.deleteCourse(course.getId());
		return ResponseEntity.status(HttpStatus.OK).body(course.getCourseName() + " isimli ders silindi!");	
	}
}

