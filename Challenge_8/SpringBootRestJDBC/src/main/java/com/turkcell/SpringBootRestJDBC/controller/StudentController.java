package com.turkcell.SpringBootRestJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.SpringBootRestJDBC.model.Student;
import com.turkcell.SpringBootRestJDBC.service.StudentService;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListStudentDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.StudentDto;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListStudentDto>> getAll() {
		return studentService.getAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<StudentDto> getById(long studentId) {
		return studentService.getById(studentId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Student student) {
		return studentService.add(student);

	}
}
