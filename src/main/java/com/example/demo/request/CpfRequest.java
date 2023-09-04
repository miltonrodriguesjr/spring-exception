package com.example.demo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CpfRequest {

    @NotNull(message = "CPF deve ser preenchido")
    @Length(min = 11, max = 11, message = "CPF deve possuir 11 caracteres")
    private String cpf;

}
