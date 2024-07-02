package com.example.mobiliario.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleException(MethodArgumentNotValidException ex){
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(errors -> {
            Error err = new Error();
            err.setField(errors.getField());
            err.setError(errors.getDefaultMessage());
            errores.add(err);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400,"Error de Datos",new Date(), errores));
    }


}
