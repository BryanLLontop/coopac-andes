package com.comperativa.losandes.models.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, String code, int statusCode) {
        ErrorResponse errorResponse = new ErrorResponse(statusCode, message, code);
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParams(MissingServletRequestParameterException ex) {
        String message = "El parámetro " + ex.getParameterName() + " es obligatorio.";
        return buildErrorResponse(message, "4001", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String message = "El método " + ex.getMethod() + " no está soportado para esta URL.";
        return buildErrorResponse(message, "4051", HttpStatus.METHOD_NOT_ALLOWED.value());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBody(HttpMessageNotReadableException ex) {
        String message = "El formato del cuerpo no es válido o no se puede leer.";
        return buildErrorResponse(message, "4003", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoHandlerFoundException ex) {
        log.error("No handler found for request: {}", ex.getRequestURL());
        String message = ex.getRequestURL() + " no existe en el servidor.";
        return buildErrorResponse(message, "4041", HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        log.error("Error en el servidor: {}", ex.getMessage(), ex);
        String message = "Ocurrió un error inesperado. Por favor intente más tarde.";
        return buildErrorResponse(message, "5000", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
