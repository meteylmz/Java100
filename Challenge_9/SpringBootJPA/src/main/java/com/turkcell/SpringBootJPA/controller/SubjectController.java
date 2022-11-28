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

import com.turkcell.SpringBootJPA.model.Subject;
import com.turkcell.SpringBootJPA.service.SubjectService;

@RestController
@RequestMapping(value = "subject")
public class SubjectController {

	@Autowired
	public SubjectService subjectService;
	
	@GetMapping(path="getAll")
	public List<Subject> getAll(){
		List<Subject> list = subjectService.getAll();
		return list;
	}
	
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Subject> getByIdEntity(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(subjectService.getById(id));
	}
	
	@PostMapping(path = "Add")
	public ResponseEntity<String> Add(@RequestBody Subject subject){
		subject = subjectService.subjectAdd(subject);
		return ResponseEntity.status(HttpStatus.CREATED).body(subject.getSubjectName() + " isimli konu eklendi!");
	}
	
	@DeleteMapping(path = "Delete")
	public ResponseEntity<String> Delete(@RequestBody Subject subject){
		subjectService.deleteSubject(subject.getId());
		return ResponseEntity.status(HttpStatus.OK).body(subject.getSubjectName() + " isimli konu silindi!");	
	}
}
