package com.example.demo.handler;

import com.example.demo.exception.InternalServerErrorException;
import com.example.demo.response.ApiCustomResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        try {
            String defaultMessage = result.getFieldError() != null && result.getFieldError().getDefaultMessage() != null
                    ? //result.getFieldError().getField() + ": " +
                    result.getFieldError().getDefaultMessage() : ex.getMessage();
            return ApiCustomResponse.generate(defaultMessage, HttpStatus.BAD_REQUEST);
        } catch (NullPointerException e) {
            log.error("Erro ao gerar mensagem de retorno: " + e.getMessage());
            throw new InternalServerErrorException("Erro ao gerar mensagem de retorno");
        }
    }
}
