package com.g3.spc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.spc.dto.ExamDto;
import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.ExamIdNotFoundException;
import com.g3.spc.repository.IExamRepository;

@Service
public class IExamServiceImpl implements IExamService {

	@Autowired 
	IExamRepository examrepo;
	
	@Override
	@Transactional
	public Exam addExam(Exam exam) {
		examrepo.save(exam);
		return exam;
	}

	@Override
	public boolean deleteExam(int id) throws ExamIdNotFoundException{
		Optional<Exam> e = examrepo.findById(id);
		Exam e1 = null;
		boolean result = false;
		if(e.isPresent()) {
			examrepo.deleteById(id);
			result = true;
		}
		else {
			throw new ExamIdNotFoundException(id);
		}
		return result;
	}

	@Override
	public Exam updateExam(Exam exam) throws ExamIdNotFoundException{
		int examId = exam.getExamId();
		Optional<Exam> e = examrepo.findById(examId);
		Exam e1 = null;
		if(e.isPresent()) {
			e1 = e.get();
			e1.setDateTimeOfExam(exam.getDateTimeOfExam());
			e1.setExamType(exam.getExamType());
			e1.setMaxMarks(exam.getMaxMarks());
			e1.setSubject(exam.getSubject());
			examrepo.save(e1);
		}
		else {
			throw new ExamIdNotFoundException(examId);
		}
		return e1;
	}

	@Override
	public List<Exam> listAllExamsByDate(String date) {
	
		return examrepo.listAllExamsByDate(date);
	}

	@Override
	public List<Exam> listAllExamsByClass(ClassId classId) {
		
		return examrepo.listAllExamsByClass(classId);
	}

	@Override
	public List<Exam> listAllExamsByStudent(Student student) {
		
		return examrepo.listAllExamsByStudent(student);
	}

	@Override
	public ExamDto listExamById(int id) throws ExamIdNotFoundException {
		Optional<Exam> e = examrepo.findById(id);
		ExamDto result = null;
		if(e.isPresent()) {
			result = getExamDetails(e.get());
		}
		else {
			throw new ExamIdNotFoundException(id);
		}
		return result;
		
	}
	
    public ExamDto getExamDetails(Exam e)  {
		List<Integer> classIdList = null;
		ExamDto result = new ExamDto(e.getExamId(),e.getDateTimeOfExam(),e.getSubject().getSubjectId(),e.getExamType(),e.getMaxMarks(),e.getClassId());
		return result;
		
	}
	
	/*@Override
    public Exam getExamDetails(ExamDto e)  {
		List<Integer> classIdList = null;
		
    	Exam result = new Exam(e.getExamId(),e.getDateTimeOfExam(),,e.getExamType(),e.getMaxMarks(),e);
		return result;
		
	}*/
}
