package com.llm.atlas.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        Throwable mostSpecificCause = e.getMostSpecificCause();
        if (mostSpecificCause instanceof InvalidFormatException invalidFormatException){
            String fieldName = invalidFormatException.getPath().getFirst().getFieldName();
            String errorMessage = "Invalid value for field " + fieldName + ": " + invalidFormatException.getValue();
            errors.put(fieldName, errorMessage);
        } else {
            errors.put("error", "Invalid request.");
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> handleNullPointerException(NullPointerException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<Map<String, String>> handleIncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "A consulta esperava um único resultado, mas retornou múltiplos registros.");
        errors.put("details", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }
}
