package com.example.demo.controller;

import com.example.demo.request.CpfRequest;
import com.example.demo.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaServiceImpl;

    public PessoaController(PessoaService pessoaServiceImpl) {
        this.pessoaServiceImpl = pessoaServiceImpl;
    }

    @PostMapping(value = "/findByCpf")
    private ResponseEntity<?> findByCpf(@RequestBody @Valid CpfRequest cpfRequest) {
        return new ResponseEntity<>(
                pessoaServiceImpl.findByCpf(cpfRequest.getCpf()),
                HttpStatus.OK);
    }

}
