package com.g3.spc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;


public interface IExamRepository extends JpaRepository<Exam , Integer>,IExamCustomRepository {
	/*public Exam addExam(Exam exam);
	public Exam deleteExam(int id);
	public Exam updateExam(Exam exam);
	public List<Exam> listAllExamsByDate(LocalDate date);
	public List<Exam> listAllExamsByClass(ClassId classId);
	public List<Exam> listAllExamsByStudent(Student student);
	public Exam listExamById(int id);*/
	

}
