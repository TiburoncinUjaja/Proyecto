package com.restaurant.carmen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.service.UsuarioService;

//Sistema de registro

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;
    
    //Controlador del registro

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    //Modelo que se toma

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }
    
    //Direccionamiento de donde esta el registro

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }
    
    //Sistema de crear un nuevo usuario

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioService.save(registroDTO);
        return "redirect:/registro?exito=true";
    }
}
