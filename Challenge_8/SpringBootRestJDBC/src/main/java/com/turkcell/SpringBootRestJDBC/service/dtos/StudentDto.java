package com.turkcell.SpringBootRestJDBC.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private String studentName;
	private long studentNumber;
	private int studentYear;
}
