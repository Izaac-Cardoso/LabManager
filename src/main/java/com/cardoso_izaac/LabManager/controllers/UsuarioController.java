package com.cardoso_izaac.LabManager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;
import com.cardoso_izaac.LabManager.domain.service.UsuarioService;
import com.cardoso_izaac.LabManager.dto.UsuarioDTO;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("Usuarios/v1")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/nome-usuario")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@RequestParam String nome) {
        var obj = service.buscarUsuarioPorNome(nome);

        return ResponseEntity.ok(obj);
    }

    @PostMapping("path")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> postMethodName(@RequestBody Usuario novoUsuario) {
        service.salvarUsuario(novoUsuario);

        return ResponseEntity.noContent().build();        
    }
    

}
