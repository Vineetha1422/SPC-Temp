package com.g3.spc.dto;

import java.util.List;

import com.g3.spc.entities.Teacher;

public class ClassIdDto {
    private String classId;
	private int grade;
	private char division;
	private TeacherDto classTeacher;
	private List<TeacherDto> subjectTeachers;
	
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
	public TeacherDto getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(TeacherDto classTeacher) {
		this.classTeacher = classTeacher;
	}
	public List<TeacherDto> getSubjectTeachers() {
		return subjectTeachers;
	}
	public void setSubjectTeachers(List<TeacherDto> subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}
	
	
}
