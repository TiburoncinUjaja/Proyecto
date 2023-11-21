package com.restaurant.carmen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurant.carmen.dto.UsuarioRegistroDTO;
import com.restaurant.carmen.service.UsuarioService;

/**
 * Controlador para gestionar las operaciones relacionadas con el sistema de registro de usuarios en la aplicación Carmen.
 */

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;
    
    /**
     * Constructor del controlador de registro.
     *
     * @param usuarioService El servicio de usuario necesario para gestionar operaciones de registro.
     */

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    /**
     * Retorna un nuevo objeto UsuarioRegistroDTO como modelo para el formulario de registro.
     *
     * @return Un nuevo objeto UsuarioRegistroDTO.
     */

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }
    
    /**
     * Muestra el formulario de registro.
     *
     * @return La vista del formulario de registro.
     */

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }
    
    /**
     * Registra una nueva cuenta de usuario.
     *
     * @param registroDTO El objeto UsuarioRegistroDTO con la información del nuevo usuario.
     * @return La redirección al formulario de registro con un indicador de éxito.
     */

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioService.save(registroDTO);
        return "redirect:/registro?exito=true";
    }
}
