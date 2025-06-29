package com.cardoso_izaac.LabManager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.zip.DataFormatException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String cpf;

    private String endereco;

    private int cep;

    @Column(name = "data_cadastro")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public void atualizaNome(String nome) {
        this.nome = nome;
    }

    public void atualizaEmail(String email) throws DataFormatException {
        if(this.email.equals(email)) {
            throw new DataFormatException("email deve ser diferente do atual");
        }

        this.email = email;
    }

    public void atualizaCpf(String cpf) {
        if(cpf.length() != 11 || cpf.equals(null)) {
            throw new RuntimeException("cpf informado é inválido.");
        }

        this.cpf = cpf;
    }

    public void atualizaEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void atualizaCep(int cep) {
        this.cep = cep;
    }

    
}
