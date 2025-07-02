package com.cardoso_izaac.LabManager.dto;

import java.time.LocalDateTime;

import com.cardoso_izaac.LabManager.domain.enums.Estado;
import com.cardoso_izaac.LabManager.domain.enums.Perfil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioDTO {
        
    private Long usuarioId;

    private String nome;
      
    private String senha;
        
    private String email;

    private Perfil perfil;

    private Estado estado;

    private final LocalDateTime dataCadastro;
}
