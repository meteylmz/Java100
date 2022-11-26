package com.turkcell.SpringBootRestJDBC.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	private long courseSubjectId;
	private String courseSubjectName;
	private long courseTeacherId;
	private String courseTeacherName;
}
