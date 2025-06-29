package com.cardoso_izaac.LabManager.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cardoso_izaac.LabManager.domain.entities.Cliente;
import com.cardoso_izaac.LabManager.domain.repositories.ClienteRepositorio;
import com.cardoso_izaac.LabManager.dto.ClienteDTO;
import com.cardoso_izaac.LabManager.exceptions.*;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    
    private final ClienteRepositorio repositorio;
    private ModelMapper mapper;

    public List<ClienteDTO> listarTodosClientes() {
        return repositorio.findAll(Sort.by(Sort.Direction.ASC))
                        .stream()
                        .map(cliente -> mapper.map(cliente, ClienteDTO.class))                        
                        .collect(Collectors.toList());                
    }

    public ClienteDTO buscaClientePorId(Long id) {     
        var cliente = repositorio.findById(id)
                        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));
        
        return mapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO buscarClientePorNome(String nome) {
        var cliente = repositorio.findByName(nome);

        return mapper.map(cliente, ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO inserir(Cliente cliente) {
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Transactional
    public void deletarClientePorId(Long id) {
        if(!repositorio.existsById(id)) {
            throw new NotFoundException("Cliente não encontrado!");
        }
        
        repositorio.deleteById(id);
    }
}
