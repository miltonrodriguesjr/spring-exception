package com.example.demo.service.impl;

import com.example.demo.exception.PessoaNotFoundException;
import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public PessoaModel findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .orElseThrow(PessoaNotFoundException::new);
    }

}
