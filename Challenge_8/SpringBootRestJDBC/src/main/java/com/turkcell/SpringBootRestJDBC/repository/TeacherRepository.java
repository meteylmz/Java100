package com.turkcell.SpringBootRestJDBC.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.mapper.TeacherRowMapper;
import com.turkcell.SpringBootRestJDBC.model.Teacher;

@Repository
public class TeacherRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Teacher> getAll() {
		String sql = "select * from obsh.ogretmen";
		ArrayList<Teacher> list = (ArrayList<Teacher>) namedParameterJdbcTemplate.query(sql, new TeacherRowMapper());
		
		return list;
	}
	
	public boolean add(Teacher teacher) {
		String sql = "insert into obsh.ogretmen (name,isgicik) values (:name,:isgicik)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", teacher.getTeacherName());
		paramMap.put("isgicik", teacher.isGicik());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public boolean delete(long teacherId) {
		String sql = "delete from obsh.ogretmen where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", teacherId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public Teacher getById(long teacherId) {
		String sql = "select * from obsh.ogretmen where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", teacherId);
		Teacher teacher = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new TeacherRowMapper());
		return teacher;
	}
}
