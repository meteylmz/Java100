package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Course;
import com.turkcell.SpringBootRestJDBC.service.CourseService;
import com.turkcell.SpringBootRestJDBC.service.dtos.CourseDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListCourseDto;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ListCourseDto>> getAll() {
		return courseService.getAll();
		
	}

	@GetMapping("/getById")
	public ResponseEntity<CourseDto> getById(@RequestParam long courseId) {
		return courseService.getById(courseId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Course course) {
		return courseService.add(course);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int courseId) {
		return courseService.delete(courseId);
	}

}
