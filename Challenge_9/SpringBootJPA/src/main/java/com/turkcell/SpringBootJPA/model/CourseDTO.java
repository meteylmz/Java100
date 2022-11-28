package com.turkcell.SpringBootJPA.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

	private String courseName;
	
	private Subject subject;
	
	private Teacher teacher;
}
