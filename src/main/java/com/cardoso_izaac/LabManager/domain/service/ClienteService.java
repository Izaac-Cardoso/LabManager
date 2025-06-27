package com.cardoso_izaac.LabManager.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cardoso_izaac.LabManager.domain.entities.Cliente;
import com.cardoso_izaac.LabManager.domain.repositories.ClienteRepositorio;
import com.cardoso_izaac.LabManager.dto.ClienteDTO;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    
    private final ClienteRepositorio repositorio;
    private ModelMapper mapper;

    private boolean validaId(Long id) {
        boolean teste;
        if(repositorio.existsById(id)) {
            teste = true;
        }

        return teste = false;
    }

    public List<ClienteDTO> listarTodosClientes() {
        return repositorio.findAll().stream()
                        .map(cliente -> mapper.map(cliente, ClienteDTO.class))
                        .collect(Collectors.toList());                
    }

    public ClienteDTO buscaClientePorId(Long id) {
        if(validaId(id)) {
            throw new RuntimeException("Cliente não encontrado!");
        }

        var cliente = repositorio.findById(id);
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO inserir(Cliente cliente) {
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Transactional
    public void deletarClientePorId(Long id) {
        if(validaId(id)) {
            throw new RuntimeException("Cliente não encontrado!");
        }
        
        repositorio.deleteById(id);
    }
}
