package com.turkcell.SpringBootRestJDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Student;
import com.turkcell.SpringBootRestJDBC.repository.StudentRepository;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListStudentDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.StudentDto;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public ResponseEntity<List<ListStudentDto>> getAll() {
		List<Student> students = studentRepository.getAll();
		List<ListStudentDto> listStudentDtos = new ArrayList<ListStudentDto>();
		for (Student student : students) {
			ListStudentDto listStudentDto = new ListStudentDto();
			listStudentDto.setStudentId(student.getStudentId());
			listStudentDto.setStudentName(student.getStudentName());
			listStudentDto.setStudentNumber(student.getStudentNumber());
			listStudentDto.setStudentYear(student.getStudentYear());
			listStudentDtos.add(listStudentDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listStudentDtos);
	}
	
	public ResponseEntity<String> add(Student student) {
		if (studentRepository.add(student)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Student is saved.");
		} else {
			return ResponseEntity.internalServerError().body("Could not save the student!");
		}

	}
	
	public ResponseEntity<String> delete(long studentId) {
		if (studentRepository.delete(studentId)) {
			return ResponseEntity.ok("Student is deleted from the database.");
		} else {
			return ResponseEntity.internalServerError().body("Could not delete the student from the database.");
		}
	}
	
	public ResponseEntity<StudentDto> getById(long studentId) {
		Student student = studentRepository.getById(studentId);

		StudentDto studentDto = new StudentDto();
		studentDto.setStudentName(student.getStudentName());
		studentDto.setStudentNumber(student.getStudentNumber());
		studentDto.setStudentYear(student.getStudentYear());

		return ResponseEntity.ok(studentDto);
	}
}
