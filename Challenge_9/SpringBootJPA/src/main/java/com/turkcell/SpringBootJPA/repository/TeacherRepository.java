package com.turkcell.SpringBootJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootJPA.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
