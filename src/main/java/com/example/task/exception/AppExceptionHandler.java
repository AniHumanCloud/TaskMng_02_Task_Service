package com.example.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<AppException>handleResoureNoFoundExc(ResourceNotFoundException ex){
        AppException appEx=new AppException();
        appEx.setErrorCode("EX001");
        appEx.setErrorMsg(ex.getMessage());
        appEx.setErrorDateAndTime(LocalDateTime.now());

        return new ResponseEntity<>(appEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
