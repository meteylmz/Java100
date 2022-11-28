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
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootJPA.model.Student;
import com.turkcell.SpringBootJPA.service.StudentService;

@RestController
@RequestMapping(value = "student")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@GetMapping(path="getAll")
	public List<Student> getAll(){
		List<Student> list = studentService.getAll();
		return list;
	}
	
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getById(id));
	}
	
	@PostMapping(path = "Add")
	public ResponseEntity<String> Add(@RequestBody Student student){
		student = studentService.studentAdd(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student.getStudentName() + " isimli öğrenci eklendi!");
	}
	
	@DeleteMapping(path = "Delete")
	public ResponseEntity<String> Delete(@RequestBody Student student){
		studentService.deleteStudent(student.getId());
		return ResponseEntity.status(HttpStatus.OK).body(student.getStudentName() + " isimli öğrenci silindi!");	
	}
	
	
}
