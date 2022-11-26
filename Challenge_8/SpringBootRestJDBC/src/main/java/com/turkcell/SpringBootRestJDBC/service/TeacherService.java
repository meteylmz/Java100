package com.turkcell.SpringBootRestJDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turkcell.SpringBootRestJDBC.model.Teacher;
import com.turkcell.SpringBootRestJDBC.repository.TeacherRepository;
import com.turkcell.SpringBootRestJDBC.service.dtos.ListTeacherDto;
import com.turkcell.SpringBootRestJDBC.service.dtos.TeacherDto;
@Service
public class TeacherService {

	@Autowired
	private TeacherRepository TeacherRepository;
	
	public ResponseEntity<List<ListTeacherDto>> getAll() {
		List<Teacher> teachers = TeacherRepository.getAll();
		List<ListTeacherDto> listTeacherDtos = new ArrayList<>();
		for (Teacher teacher : teachers) {
			ListTeacherDto listTeacherDto = new ListTeacherDto();
			listTeacherDto.setTeacherId(teacher.getTeacherId());
			listTeacherDto.setGicik(teacher.isGicik());
			listTeacherDto.setTeacherName(teacher.getTeacherName());

			listTeacherDtos.add(listTeacherDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listTeacherDtos);
	}
	
	public ResponseEntity<String> add(Teacher teacher) {
		
		TeacherRepository.add(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body("Teacher " + teacher.getTeacherName() + "  is saved in the database.");
	}
	
	public ResponseEntity<String> delete(long teacherId) {
		TeacherRepository.delete(teacherId);
		return ResponseEntity.ok("Teacher is deleted from the database.");

	}
	
	public ResponseEntity<TeacherDto> getById(long teacherId) {
		Teacher teacher = TeacherRepository.getById(teacherId);
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setGicik(teacher.isGicik());
		teacherDto.setTeacherName(teacher.getTeacherName());
		return ResponseEntity.ok(teacherDto);
	}
}
