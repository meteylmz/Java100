package com.turkcell.TeknikServis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Role //implements GrantedAuthority
{
	private static final long serialVersionUID = 3661468982812594323L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "NAME", nullable = false, unique = true, length = 100)
	private String name;

	//@Override
	public String getAuthority()
	{
		return name;
	}
}