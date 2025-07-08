package com.cardoso_izaac.LabManager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cardoso_izaac.LabManager.domain.enums.Estado;
import com.cardoso_izaac.LabManager.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public interface CriarUsuario { }

    public interface AtualizarUsuario { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotBlank
    @Size(max = 60)
    private String nome;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @NotNull(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @NotEmpty(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @Size(groups = {CriarUsuario.class, AtualizarUsuario.class}, min = 8, max = 100)
    private String senha;
    
    @NotNull(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @NotEmpty(groups = {CriarUsuario.class, AtualizarUsuario.class})
    @Size(groups = {CriarUsuario.class, AtualizarUsuario.class}, max = 60)
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }   


    
}
