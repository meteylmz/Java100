package com.turkcell.SpringBootJPA.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 200)
	private String courseName;
	
	@ManyToOne
	@JoinColumn(name = "subject-id", foreignKey = @ForeignKey(name = "subjectfk"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "teacher-id", foreignKey = @ForeignKey(name = "teacherfk"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Teacher teacher;
	
}
