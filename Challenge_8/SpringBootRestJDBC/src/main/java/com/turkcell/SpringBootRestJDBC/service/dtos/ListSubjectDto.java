package com.turkcell.SpringBootRestJDBC.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSubjectDto {

	private long subjectId;
	private String subjectName;
	
}
