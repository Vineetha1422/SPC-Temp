package com.g3.spc.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Exam {
	//------------>Fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
	name="Exam_ClassIdInfo",
	joinColumns=@JoinColumn(name="Exam_Id_t"),
	inverseJoinColumns=@JoinColumn(name="Class_Id_t"))
	private List<ClassId> classId;
	
	@Basic
	//@NotEmpty(message = "Must provide date and time")
	private LocalDateTime dateTimeOfExam;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "SubjectInfo", referencedColumnName = "subjectid")
	private Subject subject;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Cannot be Null")
	private ExamType  examType;
	
	@NotNull(message = "Must be filled")
	@Positive(message = "Invalid input")
	private int maxMarks;
	
	//-------------->Constructor
	public Exam() {
		super();
	}

	//--------------->Getters and Setters
	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}
    
	public List<ClassId> getClassId() {
		return classId;
	}

	public void setClassId(List<ClassId> classId) {
		this.classId = classId;
	}

	public LocalDateTime getDateTimeOfExam() {
		return dateTimeOfExam;
	}

	public void setDateTimeOfExam(LocalDateTime dateTimeOfExam) {
		this.dateTimeOfExam = dateTimeOfExam;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	//--------------------HashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((dateTimeOfExam == null) ? 0 : dateTimeOfExam.hashCode());
		result = prime * result + examId;
		result = prime * result + ((examType == null) ? 0 : examType.hashCode());
		result = prime * result + maxMarks;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Exam other = (Exam) obj;
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
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	//-------------ToString()
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", classId=" + classId + ", dateTimeOfExam=" + dateTimeOfExam + ", subject="
				+ subject +  ", examlist=" + examType
				+ ", maxMarks=" + maxMarks + "]";
	}

	
	
	
	
	
	
	
	
}
