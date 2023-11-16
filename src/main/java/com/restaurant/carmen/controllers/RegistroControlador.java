package com.restaurant.carmen.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {
	
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
    public String menuFull() {
        // Lógica del controlador para la página del menú
        return "menufull";
    }

}
