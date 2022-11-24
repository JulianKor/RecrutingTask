package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGloballyException(Exception e) {
        log.error("Internal exception", e);
        return ResponseEntity.internalServerError()
                .body(new ExceptionResponse(
                        List.of("System error occurred, please contact system administrator"),
                        "500",
                        LocalDateTime.now()));

    }
}
