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
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Campo obrigatório.")
    private String nome;

    @NotEmpty(message = "Campo obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    public void setId(Long id) {
        this.cliente_id = id;
    }

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
    
}
