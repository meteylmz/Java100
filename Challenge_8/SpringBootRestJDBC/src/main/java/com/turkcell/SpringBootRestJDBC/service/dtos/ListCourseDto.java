package com.turkcell.SpringBootRestJDBC.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCourseDto {

	private long courseId;
	private String courseSubjectName;
	private String courseTeacherName;
}
