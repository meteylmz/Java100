package com.turkcell.SpringBootJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.SpringBootJPA.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
