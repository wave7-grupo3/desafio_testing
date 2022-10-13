package com.grupo03.desafio_testing.advisor;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timeStamp;

    List<ValidationErrorDetail> errors;
}
