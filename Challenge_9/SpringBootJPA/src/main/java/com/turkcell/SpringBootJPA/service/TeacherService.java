package com.turkcell.SpringBootJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.SpringBootJPA.model.Teacher;
import com.turkcell.SpringBootJPA.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {

private TeacherRepository teacherRepository;
	
	public List<Teacher> getAll(){
		return teacherRepository.findAll();
	}
	
	public Teacher getById(long id) {
		return teacherRepository.findById(id).orElse(null);
	}
	
	public Teacher teacherAdd(Teacher teacher) {
		return teacherRepository.save(teacher);	
	}
	
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);
	}
}
