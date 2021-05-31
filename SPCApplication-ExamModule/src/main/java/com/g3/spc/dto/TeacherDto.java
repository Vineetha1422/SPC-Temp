package com.g3.spc.dto;

import com.g3.spc.entities.Subject;

public class TeacherDto {
    private int teacherId;
	private String name;
	
	public TeacherDto() {
		super();
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
