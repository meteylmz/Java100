package com.turkcell.SpringBootJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootJPA.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
