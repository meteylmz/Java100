package com.turkcell.SpringBootRestJDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Course;
import com.turkcell.SpringBootRestJDBC.repository.CourseRepository;
import com.turkcell.SpringBootRestJDBC.service.dtos.CourseDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListCourseDto;
import com.turkcell.SpringBootRestJDBC.service.TeacherService;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SubjectService subjectService;

	
	public ResponseEntity<String> add(Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body("Course is saved!");
	}
	
	public ResponseEntity<String> delete(long courseId){
		return ResponseEntity.status(HttpStatus.OK).body("Course is deleted!!");
	}
	
	public ResponseEntity<List<ListCourseDto>> getAll() {
		List<Course> courses = courseRepository.getAll();
		List<ListCourseDto> listCourseDtos = new ArrayList<ListCourseDto>();
		for (Course course : courses) {
			ListCourseDto listCourseDto = new ListCourseDto();
			listCourseDto.setCourseId(course.getCourseId());
			listCourseDto.setCourseTeacherName(
					teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());
			listCourseDto.setCourseSubjectName(
					subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
			listCourseDtos.add(listCourseDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listCourseDtos);
	}
	
	public ResponseEntity<CourseDto> getById(long courseId) {
		Course course = courseRepository.getById(courseId);

		CourseDto courseDto = new CourseDto();
		courseDto.setCourseSubjectId(course.getCourseSubjectId());
		courseDto.setCourseSubjectName(subjectService.getById(course.getCourseSubjectId()).getBody().getSubjectName());
		courseDto.setCourseTeacherId(course.getCourseTeacherId());
		courseDto.setCourseTeacherName(teacherService.getById(course.getCourseTeacherId()).getBody().getTeacherName());

		return ResponseEntity.ok(courseDto);
	}
}
