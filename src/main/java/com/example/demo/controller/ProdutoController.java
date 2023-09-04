package com.example.demo.controller;

import com.example.demo.exception.ProdutoNotFoundException;
import com.example.demo.request.IdRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @PostMapping(value = "/findById")
    private ResponseEntity<Object> findById(@RequestBody IdRequest idRequest) {
        if (idRequest.getId() == null) throw new ProdutoNotFoundException();
        return new ResponseEntity<>(idRequest, HttpStatus.OK);
    }

}
