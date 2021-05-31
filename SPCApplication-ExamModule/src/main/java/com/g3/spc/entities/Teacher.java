package com.g3.spc.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teacher {
	//----------------->Fields
	@Id
	private int teacherId;
	
	@NotEmpty(message = "Name must be given")
	private String name;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "SubjectInfo", referencedColumnName = "subjectid")
	private Subject subject;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "StudentTeacherInfo",
	joinColumns = @JoinColumn(name = "teacher_Id"),
	inverseJoinColumns = @JoinColumn(name = "class_Id"))
	@JsonIgnore
	private List<ClassId> classList;
	

	//----------------->Constructors
	public Teacher() {
		super();
	}

	//----------------->Getters and setters
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<ClassId> getClassList() {
		return classList;
	}

	public void setClassList(List<ClassId> classList) {
		this.classList = classList;
	}
	

	//-------------------->HashCode Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classList == null) ? 0 : classList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + teacherId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (classList == null) {
			if (other.classList != null)
				return false;
		} else if (!classList.equals(other.classList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}

	//------------------>toString()
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", subject=" + subject + ", classList="
				+ classList + "]";
	}

	
	

	
	
	
	
	
	
	
	
}
