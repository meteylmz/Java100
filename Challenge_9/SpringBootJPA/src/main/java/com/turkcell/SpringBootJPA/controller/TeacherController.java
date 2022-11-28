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

import com.turkcell.SpringBootJPA.model.Teacher;
import com.turkcell.SpringBootJPA.service.TeacherService;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

	@Autowired
	public TeacherService teacherService;
	
	@GetMapping(path="getAll")
	public List<Teacher> getAll(){
		List<Teacher> list = teacherService.getAll();
		return list;
	}
	
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Teacher> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(teacherService.getById(id));
	}
	
	@PostMapping(path = "Add")
	public ResponseEntity<String> Add(@RequestBody Teacher teacher){
		teacher = teacherService.teacherAdd(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher.getTeacherName() + " isimli ders eklendi!");
	}
	
	@DeleteMapping(path = "Delete")
	public ResponseEntity<String> Delete(@RequestBody Teacher teacher){
		teacherService.deleteTeacher(teacher.getId());
		return ResponseEntity.status(HttpStatus.OK).body(teacher.getTeacherName() + " isimli ders silindi!");	
	}
}
