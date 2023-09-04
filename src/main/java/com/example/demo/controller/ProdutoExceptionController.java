package com.example.demo.controller;

import com.example.demo.exception.ProdutoNotFoundException;
import com.example.demo.response.ApiCustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProdutoExceptionController {

    @ExceptionHandler(value = ProdutoNotFoundException.class)
    public ResponseEntity<Object> exception(ProdutoNotFoundException exception) {
        return ApiCustomResponse.generate("Produto não encontrado(a)", HttpStatus.NOT_FOUND);
    }

}
