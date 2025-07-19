package com.hipatiya.staj.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleNotValid(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }*/

    @ExceptionHandler
    public ResponseEntity<ApiError> handleInvalidArg(MethodArgumentNotValidException ex){
        Map<String, List<String>> errorsMap = new HashMap<>();

        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objError).getField();

            errorsMap
                    .computeIfAbsent(fieldName, key -> new ArrayList<>())
                    .add(objError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private ApiError createApiError(Map<String, List<String>> errors){
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }
}

