package com.cardoso_izaac.LabManager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cardoso_izaac.LabManager.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotBlank(message = "Campo obrigatório.")    
    private String nome;
    
    @JsonIgnore
    @NotEmpty(message = "Campo obrigatório.")
    @Size(min = 6, max = 8, message = "Senha deve conter entre 6 e 8 caracteres.")
    private String senha;
    
    @NotEmpty(message = "Campo obrigatório.")
    @Email(message = "E-mail inválido")
    private String email;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Column(name = "data_cadastro")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }   
    
}
