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

import com.turkcell.SpringBootRestJDBC.model.Subject;
import com.turkcell.SpringBootRestJDBC.service.SubjectService;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListSubjectDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.SubjectDto;

@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ListSubjectDto>> getAll(){
		return subjectService.getAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<SubjectDto> getById(@RequestParam long subjectId) {
		return subjectService.getById(subjectId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Subject subject) {
		return subjectService.add(subject);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int subjectId){
		return subjectService.delete(subjectId);	
		
	}
}
