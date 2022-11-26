package com.turkcell.SpringBootRestJDBC.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

	private boolean isGicik;
	private String teacherName;
}
