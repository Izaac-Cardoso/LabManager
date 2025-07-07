package com.cardoso_izaac.LabManager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.cardoso_izaac.LabManager.domain.entities.Usuario;
import com.cardoso_izaac.LabManager.domain.service.UsuarioService;
import com.cardoso_izaac.LabManager.dto.UsuarioDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
@RequestMapping("/usuarios/v1")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/sair")
    public String sair() {
        return "login";
    }    
    
    @GetMapping("/nome-usuario")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@RequestParam String nome) {
        var obj = service.buscarUsuarioPorNome(nome);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/cadastro";
        }
        
        service.salvarUsuario(novoUsuario);

        return "redirect:/login";
    }    

}
