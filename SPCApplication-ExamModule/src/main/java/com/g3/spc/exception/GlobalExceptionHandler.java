package com.g3.spc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<GlobalExceptionResponse> invalidSeedIdByUser(ExamIdNotFoundException ex)
	{
		
		int examId = ex.getExamId();
		GlobalExceptionResponse excResponse = new GlobalExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Exam Id :"+examId+ ".Please try again");
		
		
		return new ResponseEntity<GlobalExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
}
