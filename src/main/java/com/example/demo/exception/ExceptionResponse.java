package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class ExceptionResponse {
    private final List<String> errorMessages;
    private final String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime localDateTime;
}
