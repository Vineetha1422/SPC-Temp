package com.g3.spc.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.ExamType;
import com.g3.spc.entities.Subject;

public class ExamDto {
	//-------------------->Fields
	private int examId;
	private LocalDateTime dateTimeOfExam;
	private int subjectId;
	private ExamType  examType;
	private int maxMarks;
	private List<ClassId> classId;
	
	//--------------------->Constructors
	public int getExamId() {
		return examId;
	}

	public ExamDto(int examId, LocalDateTime dateTimeOfExam, int subjectId, ExamType examType, int maxMarks,
			List<ClassId> classId) {
		super();
		this.examId = examId;
		this.dateTimeOfExam = dateTimeOfExam;
		this.subjectId = subjectId;
		this.examType = examType;
		this.maxMarks = maxMarks;
		this.classId = classId;
	}

	//----------------------->Getters and Setters
	public LocalDateTime getDateTimeOfExam() {
		return dateTimeOfExam;
	}

	public void setDateTimeOfExam(LocalDateTime dateTimeOfExam) {
		this.dateTimeOfExam = dateTimeOfExam;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public List<ClassId> getClassId() {
		return classId;
	}

	public void setClassId(List<ClassId> classId) {
		this.classId = classId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	//------------------------>Hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((dateTimeOfExam == null) ? 0 : dateTimeOfExam.hashCode());
		result = prime * result + examId;
		result = prime * result + ((examType == null) ? 0 : examType.hashCode());
		result = prime * result + maxMarks;
		result = prime * result + subjectId;
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
		ExamDto other = (ExamDto) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (dateTimeOfExam == null) {
			if (other.dateTimeOfExam != null)
				return false;
		} else if (!dateTimeOfExam.equals(other.dateTimeOfExam))
			return false;
		if (examId != other.examId)
			return false;
		if (examType != other.examType)
			return false;
		if (maxMarks != other.maxMarks)
			return false;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}

	//-------------------->ToString()
	@Override
	public String toString() {
		return "ExamDto [examId=" + examId + ", dateTimeOfExam=" + dateTimeOfExam + ", subjectId=" + subjectId
				+ ", examType=" + examType + ", maxMarks=" + maxMarks + ", classId=" + classId + "]";
	}
	
	
	
	
}