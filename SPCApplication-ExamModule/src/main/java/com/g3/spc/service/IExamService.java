package com.g3.spc.service;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.dto.ExamDto;
import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.ExamIdNotFoundException;

public interface IExamService {
	public Exam addExam(Exam exam);
	public boolean deleteExam(int id)throws ExamIdNotFoundException;
	public Exam updateExam(Exam exam) throws ExamIdNotFoundException;
	public List<Exam> listAllExamsByDate(String date);
	public List<Exam> listAllExamsByClass(ClassId examByClass);
	public List<Exam> listAllExamsByStudent(Student examBystudent);
	public ExamDto listExamById(int id) throws ExamIdNotFoundException;
	

}
