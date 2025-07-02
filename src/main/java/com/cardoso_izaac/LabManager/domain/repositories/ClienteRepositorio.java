package com.cardoso_izaac.LabManager.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardoso_izaac.LabManager.domain.entities.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByName(String name);
    Optional<Cliente> findByEmail(String email);
}
