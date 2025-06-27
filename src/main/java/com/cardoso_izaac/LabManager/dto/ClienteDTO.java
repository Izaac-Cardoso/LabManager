package com.cardoso_izaac.LabManager.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteDTO {
    
    private Long cliente_id;

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty(message = "O campo e-mail não deve ser vazio.")
    private String email;

    private int cpf;

    private String endereco;

    private int cep;

    @Column(name = "data_cadastro")
    private final LocalDateTime dataCadastro;
}
