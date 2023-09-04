package com.example.demo.controller;

import com.example.demo.exception.PessoaNotFoundException;
import com.example.demo.response.ApiCustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PessoaExceptionController {

    @ExceptionHandler(value = PessoaNotFoundException.class)
    public ResponseEntity<Object> exception(PessoaNotFoundException exception) {
        return ApiCustomResponse.generate("Pessoa não encontrada", HttpStatus.NOT_FOUND);
    }

}
