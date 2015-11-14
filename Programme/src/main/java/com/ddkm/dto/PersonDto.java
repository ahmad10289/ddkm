package com.ddkm.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonDto {
	
	@Column(name="FIRST_NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
