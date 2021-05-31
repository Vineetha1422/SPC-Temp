package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class ClassId {
	//---------------->Fields
    @Id
    @NotEmpty(message = "Cannot be null or blank")
	private String classId;
	
    @NotNull(message = "Cannot be null or blank")
	private int grade;
	
    @NotNull(message = "Cannot be null or blank")
	private char division;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "classTeacher", referencedColumnName = "teacherId")
	private Teacher classTeacher;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "StudentTeacherInfo",
	joinColumns = @JoinColumn(name = "class_Id"),
	inverseJoinColumns = @JoinColumn(name = "teacher_Id"))
	private List<Teacher> subjectTeachers; 
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
	name="Exam_ClassIdInfo",
	joinColumns=@JoinColumn(name="Class_Id_t"),
	inverseJoinColumns=@JoinColumn(name="Exam_Id_t"))
	@JsonIgnore
	private List<Exam> examlist;
	
	//----------------->Constructors
	
	public ClassId(int grade,char division){
		this.grade =  grade;
		this.division = division;
		this.classId =  ""+this.grade+this.division;
		
	}
		
	public ClassId() {
		super();
	}


	//------------------>Getters and Setters
	public String getClassId() {
		return classId;
	}



	public void setClassId(String classId) {
		this.classId = classId;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public char getDivision() {
		return division;
	}



	public void setDivision(char division) {
		this.division = division;
	}



	public Teacher getClassTeacher() {
		return classTeacher;
	}



	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}



	public List<Teacher> getSubjectTeachers() {
		return subjectTeachers;
	}



	public void setSubjectTeachers(List<Teacher> subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}
	
	
    
    public List<Exam> getExamlist() {
		return examlist;
	}

	public void setExamlist(List<Exam> examlist) {
		this.examlist = examlist;
	}

	//------------------->Hash and equals
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((classTeacher == null) ? 0 : classTeacher.hashCode());
		result = prime * result + division;
		result = prime * result + ((examlist == null) ? 0 : examlist.hashCode());
		result = prime * result + grade;
		result = prime * result + ((subjectTeachers == null) ? 0 : subjectTeachers.hashCode());
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
		ClassId other = (ClassId) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (classTeacher == null) {
			if (other.classTeacher != null)
				return false;
		} else if (!classTeacher.equals(other.classTeacher))
			return false;
		if (division != other.division)
			return false;
		if (examlist == null) {
			if (other.examlist != null)
				return false;
		} else if (!examlist.equals(other.examlist))
			return false;
		if (grade != other.grade)
			return false;
		if (subjectTeachers == null) {
			if (other.subjectTeachers != null)
				return false;
		} else if (!subjectTeachers.equals(other.subjectTeachers))
			return false;
		return true;
	}

	//----------------ToString()
	@Override
	public String toString() {
		return "ClassId [classId=" + classId + ", grade=" + grade + ", division=" + division + ", classTeacher="
				+ classTeacher + ", subjectTeachers=" + subjectTeachers + ", examlist=" + examlist + "]";
	}

	
	


	/*public static void main(String[] args) {
		
		ClassId ca = new ClassId(3, 'a');
		System.out.println(ca);
	}*/
}
