package com.assessment.restservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return createErrorResponse(ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return createErrorResponse(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({FeatureNotFoundException.class})
    public final ResponseEntity<Object> handleFeatureNotFoundException(FeatureNotFoundException ex, WebRequest request) {
        return createErrorResponse(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> createErrorResponse(String message, String details, HttpStatus httpStatus) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message, details, new ArrayList<>());
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
