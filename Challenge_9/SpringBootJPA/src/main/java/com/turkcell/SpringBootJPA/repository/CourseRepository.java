package com.turkcell.SpringBootJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turkcell.SpringBootJPA.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	@Modifying
	@Query("delete from Course c where c.courseName=:course_name")
	void deleteCourse(@Param("course_name") String courseName);
}
