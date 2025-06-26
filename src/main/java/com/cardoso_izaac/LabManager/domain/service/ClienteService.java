package com.cardoso_izaac.LabManager.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cardoso_izaac.LabManager.domain.entities.Cliente;
import com.cardoso_izaac.LabManager.domain.repositories.ClienteRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    
    private final ClienteRepositorio repositorio;

    private boolean validaId(Long id) {
        boolean teste;
        if(repositorio.existsById(id)) {
            teste = true;
        }

        return teste = false;
    }

    public List<Cliente> listarTodosClientes() {
        return repositorio.findAll();
    }

    public Optional<Cliente> buscaClientePorId(Long id) {
        if(validaId(id)) {
            throw new RuntimeException("Cliente não encontrado!");
        }

        return repositorio.findById(id);
    }

    public void deletarClientePorId(Long id) {
        if(validaId(id)) {
            throw new RuntimeException("Cliente não encontrado!");
        }
        
        repositorio.deleteById(id);
    }
}
