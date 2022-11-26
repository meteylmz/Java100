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

import com.turkcell.SpringBootRestJDBC.model.Teacher;
import com.turkcell.SpringBootRestJDBC.service.TeacherService;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListTeacherDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.TeacherDto;

@RestController
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListTeacherDto>> getAll(){
		return teacherService.getAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<TeacherDto> getById(long teacherId) {
		return teacherService.getById(teacherId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Teacher teacher) {
		return teacherService.add(teacher); 
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int teacherId){
		return teacherService.delete(teacherId);			
	}
}