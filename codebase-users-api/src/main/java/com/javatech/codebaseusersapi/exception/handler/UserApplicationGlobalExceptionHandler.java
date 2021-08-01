package com.javatech.codebaseusersapi.exception.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javatech.codebaseusersapi.constants.UserApplicationMessageConstants;
import com.javatech.codebaseusersapi.exception.EntityAlreadyExistsException;
import com.javatech.codebaseusersapi.exception.EntityNotFoundException;
import com.javatech.codebaseusersapi.ui.model.UserApplicationExceptionResponse;

@RestControllerAdvice
public class UserApplicationGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = EntityAlreadyExistsException.class)
	public ResponseEntity<Object> handleConflct(EntityAlreadyExistsException ex, WebRequest webRequest) {
		UserApplicationExceptionResponse exceptionResponse = new UserApplicationExceptionResponse();
		exceptionResponse.getMessages().add(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.CONFLICT.value());
		exceptionResponse.setTimestamp(System.currentTimeMillis());
		ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
		return entity;
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<Object> handleNotFound(EntityNotFoundException ex, WebRequest webRequest) {
		UserApplicationExceptionResponse exceptionResponse = new UserApplicationExceptionResponse();
		exceptionResponse.getMessages().add(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setTimestamp(System.currentTimeMillis());
		ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(value = { RuntimeException.class, SQLException.class })
	public ResponseEntity<Object> handleAny(RuntimeException ex, HttpServletRequest request,
			HttpServletResponse response) {
		UserApplicationExceptionResponse exceptionResponse = new UserApplicationExceptionResponse();
		exceptionResponse.getMessages().add(UserApplicationMessageConstants.DEFAULT_ERROR_MESSAGE);
		exceptionResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setTimestamp(System.currentTimeMillis());
		ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		UserApplicationExceptionResponse exception = new UserApplicationExceptionResponse();
		exception.setTimestamp(System.currentTimeMillis());
		exception.setStatus(HttpStatus.BAD_REQUEST.value());
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			exception.getMessages().add(error.getDefaultMessage());
		});
		ResponseEntity<Object> entity = new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
		return entity;
	}
}
