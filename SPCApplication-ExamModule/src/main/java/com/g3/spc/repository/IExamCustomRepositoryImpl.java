package com.g3.spc.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;

public class IExamCustomRepositoryImpl implements IExamCustomRepository {

	@Autowired
	EntityManager entityManager; 
	
	@Override
	public List<Exam> listAllExamsByDate(String date) {
		Query q = entityManager.createQuery("from Exam where date_Time_Of_Exam like :date");
		q.setParameter("date", date +"%");
		return q.getResultList();
	}

	@Override
	public List<Exam> listAllExamsByClass(ClassId examByClass) {//isn't id just enough?
		Query q = entityManager.createQuery("select e.exam_id_t from Exam_class_id_info e where e.class_id_t = :class_id ");
		q.setParameter("class_id", examByClass.getClassId());
		List<Integer> exam_id_list = (List<Integer>)q.getResultList();
		List<Exam> result = null;
		for(Integer i:exam_id_list) {
			Query q1 = entityManager.createQuery("from exam where exam_id = :examid");
			q1.setParameter("examid" , i);
			result.add((Exam)q1.getResultList());
		}
		return result;
	}

	@Override
	public List<Exam> listAllExamsByStudent(Student examBystudent) {
		Query q = entityManager.createQuery("from Exam where classId = :examBystudent");
		q.setParameter("examBystudent", examBystudent);
		return q.getResultList();
	}

}
