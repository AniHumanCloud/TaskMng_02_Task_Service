package com.example.task.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppException {

    private String errorCode;
    private String errorMsg;
    private LocalDateTime errorDateAndTime;
}

