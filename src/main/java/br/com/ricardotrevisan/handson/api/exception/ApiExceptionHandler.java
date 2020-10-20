package br.com.ricardotrevisan.handson.api.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ricardotrevisan.handson.domain.exception.BusinessException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
		
	@ExceptionHandler(BusinessException.class) 
	public ResponseEntity<Object> handleNegocio(BusinessException ex, WebRequest request) {
		System.out.println(" -----------------------------------------------------------");
		var status = HttpStatus.BAD_REQUEST;
		var problem = new Problem();
		//FIXME
		System.out.println("mensagem: " + ex.getMessage());
		problem.setStatus(status.value());		
		problem.setTitle(messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale()));
		problem.setDateTime(OffsetDateTime.now());
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		var status = HttpStatus.NOT_FOUND;
		var problem = new Problem();
		problem.setStatus(status.value());		
		problem.setTitle(messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale()));
		problem.setDateTime(OffsetDateTime.now());
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		var fields = new ArrayList<Problem.Field>();	
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			fields.add(new Problem.Field(fieldName, message));
		}
		
		var problem = new Problem();
		problem.setStatus(status.value());
		problem.setDateTime(OffsetDateTime.now());
		problem.setTitle("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente");
		problem.setFields(fields);
		return super.handleExceptionInternal(ex, problem, headers, status, request);
	}
}
