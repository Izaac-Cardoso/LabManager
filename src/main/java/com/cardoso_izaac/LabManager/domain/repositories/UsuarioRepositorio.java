package com.cardoso_izaac.LabManager.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByNomeAndEmail(String nome, String email);
}
