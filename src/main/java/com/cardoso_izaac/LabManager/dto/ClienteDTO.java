package com.cardoso_izaac.LabManager.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteDTO {
    
    private Long cliente_id;

    private String nome;

    private String email;

    private int cpf;

    private String endereco;

    private int cep;
    
    private final LocalDateTime dataCadastro;
}
