package com.turkcell.SpringBootJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootJPA.model.Student;
import com.turkcell.SpringBootJPA.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	private StudentRepository studentRepository;
	
		public List<Student> getAll(){
			return studentRepository.findAll();
		}
		
		public Student getById(long id) {
			return studentRepository.findById(id).orElse(null);
		}
		
		public Student studentAdd(Student student) {
			return studentRepository.save(student);	
		}
		
		public void deleteStudent(long id) {
			studentRepository.deleteById(id);
		}
}
