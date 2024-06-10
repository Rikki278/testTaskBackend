package org.example.backtesttask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Marks this class as a global exception handler for REST controllers
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // Handles validation exceptions
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); // Map to store field error messages
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()) // Populate the map with field errors
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Return the errors with 400 Bad Request status
    }
}
