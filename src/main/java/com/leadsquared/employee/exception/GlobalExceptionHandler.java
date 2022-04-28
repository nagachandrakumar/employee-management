package com.leadsquared.employee.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundError.class, EntityNotFoundException.class})
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = null;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(ex instanceof EmployeeNotFoundError){
            status = HttpStatus.NOT_FOUND;
            exceptionResponse = new ExceptionResponse(status.toString(), ex.getMessage(), request.getDescription(false));
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            exceptionResponse = new ExceptionResponse(status.toString(), ex.getMessage(), request.getDescription(false));
        }
        return new ResponseEntity<Object>(exceptionResponse, status);
    }

}