package com.cardoso_izaac.LabManager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cardoso_izaac.LabManager.domain.enums.Estado;
import com.cardoso_izaac.LabManager.domain.enums.Perfil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "data_cadastro")
    private final LocalDateTime dataCadastro;
}
