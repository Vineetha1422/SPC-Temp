package com.g3.spc.repository;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;

public interface IExamCustomRepository {
	public List<Exam> listAllExamsByDate(String date);
	public List<Exam> listAllExamsByClass(ClassId examByClass);
	public List<Exam> listAllExamsByStudent(Student examBystudent);
}
