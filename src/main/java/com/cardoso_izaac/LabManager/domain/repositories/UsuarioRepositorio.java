package com.cardoso_izaac.LabManager.domain.repositories;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByName(String nome);
    Optional<Usuario> findByNameAndEmail(String nome, String email);
}
