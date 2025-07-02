package com.cardoso_izaac.LabManager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardoso_izaac.LabManager.domain.entities.Cliente;
import com.cardoso_izaac.LabManager.domain.service.ClienteService;
import com.cardoso_izaac.LabManager.dto.ClienteDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes/v1")
public class ClienteController {
    
    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listaDeClientes() {
        var clientes = service.listarTodosClientes();

        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{cliente_id}")
    public ResponseEntity<ClienteDTO> buscaPorId(@PathVariable Long id) {
        var cliente = service.buscaClientePorId(id);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/nome-cliente")
    public ResponseEntity<ClienteDTO> buscarCliente(@RequestParam String nome) {
        var cliente = service.buscarClientePorNome(nome);

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("path/{id}")
    public ResponseEntity<Void> atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        service.atualizaCliente(cliente);
        
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody Cliente cliente) {      

        return ResponseEntity.ok(service.inserir(cliente));
    }
        
    @DeleteMapping("/{cliente_id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        service.deletarClientePorId(id);

        return ResponseEntity.noContent().build();
    }

}
