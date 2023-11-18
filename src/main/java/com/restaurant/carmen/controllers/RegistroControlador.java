package com.restaurant.carmen.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.carmen.models.Reserva;
import com.restaurant.carmen.models.Usuario;
import com.restaurant.carmen.repository.ReservaRepository;
import com.restaurant.carmen.service.UsuarioService;

@Controller
public class RegistroControlador {
	
	@Autowired
    private ReservaRepository reservaRepository;
	
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
        
        List<Reserva> reservas = reservaRepository.findAll(); // Obtener todas las reservas
        model.addAttribute("reservas", reservas); // Agregar las reservas al modelo
        
        return "menufull";
        
        
        
    }
	@GetMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Long id, Model model) {
	    Usuario usuario = servicio.obtenerUsuarioPorId(id);
	    model.addAttribute("usuario", usuario);
	    return "edit";
	}

	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute Usuario usuario) {
	    servicio.actualizarUsuario(usuario);
	    return "redirect:/menufull";
	}

	@PostMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@RequestParam Long id) {
	    servicio.eliminarUsuario(id);
	    return "redirect:/menufull?exito=true";
	}
	
	@PostMapping("/eliminarReserva/{id}")
	public String eliminarReserva(@PathVariable Long id) {
	    servicio.eliminarReserva(id);
	    return "redirect:/menufull?exito=true";
	}
}
