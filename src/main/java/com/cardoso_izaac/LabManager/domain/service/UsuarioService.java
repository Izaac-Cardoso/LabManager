package com.cardoso_izaac.LabManager.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;
import com.cardoso_izaac.LabManager.domain.repositories.UsuarioRepositorio;
import com.cardoso_izaac.LabManager.dto.UsuarioDTO;
import com.cardoso_izaac.LabManager.exceptions.DuplicateException;
import com.cardoso_izaac.LabManager.exceptions.NotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
    
    private final UsuarioRepositorio repositorio;
    private final PasswordEncoder passWordEncoder;
    private final ModelMapper mapper;
    
    public UsuarioDTO buscarUsuarioPorNome(String nome) {
        Usuario usuario = repositorio.findByNome(nome)
                    .orElseThrow(() -> new NotFoundException(String.format("Usuário '%s' não encontrado!", nome)));

        return mapper.map(usuario, UsuarioDTO.class);
    }
    
    @Transactional
    public void salvarUsuario(Usuario usuario) {
        String email = usuario.getEmail();
        repositorio.findByEmail(email)
        .orElseThrow(() -> new DuplicateException(String.format("Já existe um usuário cadastrado com o e-mail '%s'!", email)));

        String senhaHash = passWordEncoder.encode(usuario.getSenha());
        usuario.setEmail(senhaHash);
        repositorio.save(usuario);
    }

}
