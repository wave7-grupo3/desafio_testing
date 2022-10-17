package com.grupo03.desafio_testing.advisor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    /**
     * Método responsável pelo tratamento das exceções geradas ao validar os campos de uma entidade.
     * @author Grupo 03
     * @param ex - MethodArgumentNotValidException
     * @param headers - HttpHeaders
     * @param status - HttpStatus
     * @param request - WebRequest
     * @return ErrorDetails - Retorna uma entidade do tipo ErrorDetails.
     */
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

    /**
     * Método responsável pelo tratamento das exceções geradas ao validar o tipo de um campo.
     * @author Grupo 03
     * @param ex - HttpMessageNotReadableException
     * @param headers - HttpHeaders
     * @param status - HttpStatus
     * @param request - WebRequest
     * @return ErrorDetails - Retorna uma entidade do tipo ErrorDetails.
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var errorDetail = ErrorDetails.builder()
                .title("Validation Error")
                .message("The type you enter must be a number.")
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    /**
     * Método responsável pelo tratamento das exceções geradas quando a solicitação não for encontrada.
     * @author Grupo 03
     * @param ex - NotFoundException
     * @return ErrorDetails - Retorna uma entidade do tipo ErrorDetails.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerNotFoundException(NotFoundException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .title("Not found!")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
