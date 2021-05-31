package com.g3.spc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Subject {
	//--------------->Fields
	@Id
	private int subjectId;
	
	private String title;
	
	//--------------->Constructors
	public Subject() {
		super();
	}
	

	public Subject(int subjectId, String title) {
		super();
		this.subjectId = subjectId;
		this.title = title;
	}


	//--------------->Getters and Setters
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subjectId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	//----------------->HashCode and equal
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectId != other.subjectId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	//------------------>toString()
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", title=" + title + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
