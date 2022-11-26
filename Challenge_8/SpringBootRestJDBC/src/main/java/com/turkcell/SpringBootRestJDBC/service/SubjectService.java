package com.turkcell.SpringBootRestJDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Subject;
import com.turkcell.SpringBootRestJDBC.repository.SubjectRepository;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListSubjectDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.SubjectDto;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository SubjectRepository;

	public ResponseEntity<List<ListSubjectDto>> getAll() {

		List<Subject> subjects = SubjectRepository.getAll();
		List<ListSubjectDto> listSubjectDtos = new ArrayList<ListSubjectDto>();

		for (Subject subject : subjects) {
			ListSubjectDto listSubjectDto = new ListSubjectDto(subject.getSubjectId(), subject.getSubjectName());

			listSubjectDtos.add(listSubjectDto);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(listSubjectDtos);
	}
	
	public ResponseEntity<String> add(Subject subject) {
		if (SubjectRepository.add(subject)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Subject "+subject.getSubjectName()+" is saved in the database.");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Subject could not be saved.");
		}
	}
	
	public ResponseEntity<String> delete(long subjectId) {
		if(SubjectRepository.delete(subjectId)) {
			return ResponseEntity.ok("Subject is deleted.");
		}else {
			return ResponseEntity.internalServerError().body("Could not delete the subject.");
		}
	}
	
	public ResponseEntity<SubjectDto> getById(long subjectId) {
		Subject subject = SubjectRepository.getById(subjectId);
		SubjectDto subjectDto = new SubjectDto(subject.getSubjectName());
		return ResponseEntity.status(HttpStatus.FOUND).body(subjectDto);
	}
}
