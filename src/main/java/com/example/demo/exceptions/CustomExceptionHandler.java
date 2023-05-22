package com.example.demo.exceptions;

import com.example.demo.responses.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import com.example.demo.exceptions.NotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response> handleAllExceptions(Exception ex, WebRequest request, InputStream inputStream) throws IOException {
        return handleException("Internal Server Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Response> handleNotFoundExceptions(NotFoundException ex, WebRequest request) {
        return handleException(ex.getDescription(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Response> handleException(String message, HttpStatus httpStatus) {
        Response errorResponse = new Response(message);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
