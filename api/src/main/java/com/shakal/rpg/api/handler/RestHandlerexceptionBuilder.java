package com.shakal.rpg.api.handler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.DuplicatedResourceException;
import com.shakal.rpg.api.exception.ExceptionReponseDetail;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestHandlerexceptionBuilder {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ExceptionReponseDetail resourceNotFoundDetail = new ExceptionReponseDetail(
                "Resource not found!",
                HttpStatus.NOT_FOUND.value(),
                resourceNotFoundException.getMessage(),
                
               resourceNotFoundException.getClass().getName());

        return new ResponseEntity<>(resourceNotFoundDetail, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DuplicatedResourceException.class)
    public ResponseEntity<?> handlerDuplitatedResourceException(DuplicatedResourceException duplicatedException) {
        ExceptionReponseDetail resourceNotFoundDetail = new ExceptionReponseDetail( 
                "Duplicated Resource",
                HttpStatus.CONFLICT.value(),
                duplicatedException.getMessage(),
                duplicatedException.getClass().getName()
                );

        return new ResponseEntity<>(resourceNotFoundDetail, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handlerBusinessException(BusinessException businessException) {
        ExceptionReponseDetail resourceNotFoundDetail = new ExceptionReponseDetail( 
                "Business Exception",
                HttpStatus.CONFLICT.value(),
                businessException.getMessage(),
                businessException.getClass().getName()
                );

        return new ResponseEntity<>(resourceNotFoundDetail, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        ExceptionReponseDetail apiError = new ExceptionReponseDetail(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getLocalizedMessage(),
                ex.getClass().getName()
                );

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
