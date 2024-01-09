package com.emc.cm.advice;

import com.emc.cm.exception.DatabaseAccessException;
import com.emc.cm.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException exception){
        ApiError apiError = new ApiError(404, exception.getMessage(), new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseAccessException.class)
    public ResponseEntity<ApiError> handleDatabaseException(DatabaseAccessException databaseAccessException){
        ApiError apiError = new ApiError(500, databaseAccessException.getMessage(), new Date());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

