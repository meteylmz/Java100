package com.turkcell.SpringBootRestJDBC.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.mapper.CourseRowMapper;
import com.turkcell.SpringBootRestJDBC.model.Course;

@Repository
public class CourseRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<Course> getAll(){
		String sql = "select * from obsh.ders";
		List<Course> list = namedParameterJdbcTemplate.query(sql, new CourseRowMapper());
		return list;
	}
	
	public boolean delete(long courseId) {
		String sql = "select * from obsh.ders where (id) =: id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseId);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
	
	public Course getById(long courseId) {
		String sql = "select * from obsh.ders where id =: id";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", courseId);
		Course course = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new CourseRowMapper());
		return course;
	}
	
	public boolean add(Course course) {
		String sql = "insert into obsh.ders (konu_id,ogretmen_id) values (:konu_id,:ogretmen_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("konu_id", course.getCourseSubjectId());
		paramMap.put("ogretmen_id", course.getCourseTeacherId());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
}
