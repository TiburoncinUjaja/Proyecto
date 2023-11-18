package com.restaurant.carmen.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.carmen.service.UsuarioService;

@Controller
public class RegistroControlador {
	
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verInicio() {
		return "home";
	}
	
	@GetMapping("/home")
	public String verInicio2() {
		return "home";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/reserv")
	public String reserv() {
		return "reserv";
	}
	
	@GetMapping("formreserv")
	 public String tuMetodo(Model model, Principal principal) {
        String username = principal.getName();
        
        model.addAttribute("username", username);
        
        Collection<? extends GrantedAuthority> authorities = ((Authentication) principal).getAuthorities();

        boolean isAdmin = authorities.stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin);

        return "formreserv";
    }
	
	@GetMapping("/menufull")
    @Secured("ROLE_ADMIN")
    public String menuFull(Model model, Principal principal) {
        String username = principal.getName();
        
        model.addAttribute("username", username);
        
        Collection<? extends GrantedAuthority> authorities = ((Authentication) principal).getAuthorities();

        boolean isAdmin = authorities.stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin);
        
        model.addAttribute("usuarios", servicio.listarUsuarios());
        
        return "menufull";
        
        
        
    }
	@GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        // Lógica para cargar los datos del usuario y pasarlos al formulario de edición
        return "editarUsuario"; // Puedes crear una nueva página HTML para la edición
    }

    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        // Lógica para eliminar el usuario con el ID proporcionado
        // Puedes utilizar el servicio de UsuarioService y el repositorio UsuarioRepository aquí
        return "redirect:/menufull"; // Redirige de nuevo a la página del menú después de eliminar
    }

}
