package com.example.validcardservice.exception;

import com.example.validcardservice.exception.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(IdNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
        }
