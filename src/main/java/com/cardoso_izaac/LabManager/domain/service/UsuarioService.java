package com.cardoso_izaac.LabManager.domain.service;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;
import com.cardoso_izaac.LabManager.domain.repositories.UsuarioRepositorio;
import com.cardoso_izaac.LabManager.dto.UsuarioDTO;
import com.cardoso_izaac.LabManager.exceptions.NotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
    
    private final UsuarioRepositorio repositorio;
    private final ModelMapper mapper;
    
    public UsuarioDTO buscarUsuarioPorNome(String nome) {
        Usuario usuario = repositorio.findByName(nome)
                    .orElseThrow(() -> new NotFoundException("Usuário " + nome + " não encontrado!"));

        return mapper.map(usuario, UsuarioDTO.class);

    }
    
    public void salvarUsuario(Usuario usuario) {
        repositorio.findByNameAndEmail(usuario.getNome(), usuario.getEmail())
        .orElseThrow(() -> new RuntimeException("Nome ou email já cadastrados!"));

        repositorio.save(usuario);

    }

}
