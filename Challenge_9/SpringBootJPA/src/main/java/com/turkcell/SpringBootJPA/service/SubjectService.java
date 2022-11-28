package com.turkcell.SpringBootJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootJPA.model.Subject;
import com.turkcell.SpringBootJPA.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectService {

private SubjectRepository subjectRepository;
	
	public List<Subject> getAll(){
		return subjectRepository.findAll();
	}
	
	public Subject getById(long id) {
		return subjectRepository.findById(id).orElse(null);
	}
	
	public Subject subjectAdd(Subject subject) {
		return subjectRepository.save(subject);	
	}
	
	public void deleteSubject(long id) {
		subjectRepository.deleteById(id);
	}
}
