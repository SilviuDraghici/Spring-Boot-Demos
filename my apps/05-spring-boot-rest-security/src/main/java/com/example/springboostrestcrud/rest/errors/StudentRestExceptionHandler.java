package com.example.springboostrestcrud.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseBody> handleStudentNotFound(EntityNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseBody response = new ErrorResponseBody();
        response.setStatus(status.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseBody> handleStudentNotFound(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorResponseBody response = new ErrorResponseBody();
        response.setStatus(status.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, status);
    }
}
