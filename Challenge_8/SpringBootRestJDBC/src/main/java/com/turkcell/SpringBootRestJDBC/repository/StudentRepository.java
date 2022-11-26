package com.turkcell.SpringBootRestJDBC.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.mapper.StudentRowMapper;
import com.turkcell.SpringBootRestJDBC.model.Student;

@Repository
public class StudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Student> getAll() {
		String sql = "select * from obsh.ogrenci";
		ArrayList<Student> list = (ArrayList<Student>) namedParameterJdbcTemplate.query(sql, new StudentRowMapper());
		return list;
	}
	
	public boolean add(Student student) {
		String sql = "insert into obsh.ogrenci (name,ogrnumber,year) values (:name,:ogrnumber,:year)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", student.getStudentName());
		paramMap.put("ogrnumber", student.getStudentNumber());
		paramMap.put("year", student.getStudentYear());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public boolean delete(long studentId) {
		String sql = "delete from obsh.ogrenci where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", studentId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public Student getById(long studentId) {
		String sql = "select * from obsh.ogrenci where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", studentId);
		Student student = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new StudentRowMapper());
		return student;
	}
}
