package com.g3.spc.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.g3.spc.dto.ExamDto;
import com.g3.spc.entities.ClassId;
import com.g3.spc.entities.Exam;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.ExamIdNotFoundException;
import com.g3.spc.service.IExamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/spc")
@Api(value = "School Parent Communication App",description = "Various api to provide servies on Exam module")

public class SPCRestController {
     public SPCRestController() {
    	 System.out.println("----------->Rest Controller Begin!");
     }
     
     @GetMapping("/home")
     public String homeString() {
    	 return "Welcome to Teacher Parent Communication Application";
     }
     
     //-------------->IExamService
     @Autowired
     private IExamService examservice;
     
     
     //Without Dto
     /*@PostMapping("/exam/insert")//done
     @Transactional
     public Exam insertExam(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)Exam e) {
    	 examservice.addExam(e);
    	 return e;
     }*/
     
     @ApiOperation(value = "Exam insertion" , response = Exam.class)
     @PostMapping("/exam/insert")//done
     @Transactional
     public Exam insertExam(@RequestBody @Valid @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Exam e) {
    	 examservice.addExam(e);
    	 return e;
     }
     
     @DeleteMapping("/exam/delete/{exam_id}")//done
     @Transactional
     public String deleteExam(@PathVariable("exam_id")int exam_id) throws ExamIdNotFoundException {
    	 examservice.deleteExam(exam_id);
    	 return "Deleted!";
     }
     
     @PutMapping("/exam/update")//done
     public Exam updateExam(@RequestBody @Valid Exam e) throws ExamIdNotFoundException {
    	 return examservice.updateExam(e);
     }
     
     @ApiOperation(value = "Search for exam details based on Id" , response = Exam.class)
     @GetMapping("exam/search/{exam_id}")//done
     public ExamDto listExamById(@PathVariable("exam_id") int exam_id) throws ExamIdNotFoundException {
    	 return examservice.listExamById(exam_id);
     }
          
     @GetMapping("exam/filterdate/{date}")
     public List<Exam> listExamByDate(@PathVariable("date") String date){
    	 //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yy");
    	 //LocalDate d = LocalDate.parse(date,formatter);
    	 return examservice.listAllExamsByDate(date);
     }
     
     @PostMapping("exam/filterclass")
     public List<Exam> listExamByClass(@RequestBody ClassId c){
    	 return examservice.listAllExamsByClass(c);
     }
     
     @GetMapping("exam/filterstudent")
     public List<Exam> listExamByStudent(@RequestBody Student s){
    	 return examservice.listAllExamsByStudent(s);
     }
     
}
