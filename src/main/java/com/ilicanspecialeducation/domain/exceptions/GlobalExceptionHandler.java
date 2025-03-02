package com.ilicanspecialeducation.domain.exceptions;

import com.ilicanspecialeducation.domain.data.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundException.class, PostNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFound(RuntimeException ex, WebRequest webRequest) {
        Map<String ,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message", ex.getMessage());
        body.put("error message", ex.getMessage());
        return new ResponseEntity<>(new BaseResponse<>(null, ErrorType.NOT_FOUND.name(), body,false), HttpStatus.NOT_FOUND);
    }
}
