package com.turkcell.SpringBootRestJDBC.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.mapper.SubjectRowMapper;
import com.turkcell.SpringBootRestJDBC.model.Subject;

@Repository
public class SubjectRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Subject> getAll() {
		String sql = "select * from obsh.konu";
		ArrayList<Subject> list = (ArrayList<Subject>) namedParameterJdbcTemplate.query(sql, new SubjectRowMapper());
		return list;
	}
	
	public boolean add(Subject subject) {
		String sql = "insert into obsh.konu (name) values (:name)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", subject.getSubjectName());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public boolean delete(long subjectId) {
		String sql = "delete from obsh.konu where id = :id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", subjectId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public Subject getById(long subjectId) {
		String sql = "select * from obsh.konu where (id)=:id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", subjectId);
		Subject subject = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new SubjectRowMapper());
		return subject;
	}
}

