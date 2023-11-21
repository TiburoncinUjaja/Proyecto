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
	
	//Redireccionamiento a todas las paginas

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
	
	//Redireccionamiento al formulario de reservas, donde se solicita El nombre del usuario, su correo 
	// su email y su rol
	
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
	
	//Redireccionamiento al formulario del menufull del administrador, donde se solicita la tabla de usuarios.
	// de reservas, rol de administrador y los servicios de enlistar junto con los crud
	
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
        
        List<Reserva> reservas = reservaRepository.findAll(); 
        model.addAttribute("reservas", reservas);
        
        return "menufull";
        
        
        
    }
	
	//Mapeo de editar por Id
	
	@GetMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Long id, Model model) {
	    Usuario usuario = servicio.obtenerUsuarioPorId(id);
	    model.addAttribute("usuario", usuario);
	    return "edit";
	}
	
	//Mapeo de actualizar usuarios

	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute Usuario usuario) {
	    servicio.actualizarUsuario(usuario);
	    return "redirect:/menufull";
	}
	
	//Mapeo para eliminar usuario por Id

	@PostMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@RequestParam Long id) {
	    servicio.eliminarUsuario(id);
	    return "redirect:/menufull?exito=true";
	}
	
	//Mapeo de eliminar reserva por Id
	
	@PostMapping("/eliminarReserva/{id}")
	public String eliminarReserva(@PathVariable Long id) {
	    servicio.eliminarReserva(id);
	    return "redirect:/menufull?exito=true";
	}
}
