package com.basicquiz.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Objects;

//TODO GTB-工程实践: - 两个方法里的重复代码有点多，可以提取一下。
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {

        String timeStamp = new Date().toString();
        long status = HttpStatus.BAD_REQUEST.value();
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
        ErrorResult errorResult = new ErrorResult(timeStamp, status, message, error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResult> handle(ResponseStatusException ex) {

        String timeStamp = new Date().toString();
        long status = HttpStatus.NOT_FOUND.value();
        String message = ex.getReason();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();
        ErrorResult errorResult = new ErrorResult(timeStamp, status, message, error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}