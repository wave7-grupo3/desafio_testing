package com.grupo03.desafio_testing.advisor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ValidationErrorDetail> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> ValidationErrorDetail.builder()
                        .field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .rejectedValue(String.valueOf(fieldError.getRejectedValue()))
                        .build())
                .collect(Collectors.toList());

        var errorDetail = ErrorDetails.builder()
                .title("Validation Error")
                .message("The following validation(s) error(s) occurred:")
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .timeStamp(LocalDateTime.now())
                .errors(errors)
                .build();

        return new ResponseEntity<>(errorDetail, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
