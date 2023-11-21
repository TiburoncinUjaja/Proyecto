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

/**
 * Controlador para gestionar las operaciones relacionadas con la navegación y manipulación de datos en la aplicación Carmen.
 */

@Controller
public class RegistroControlador {
	
	@Autowired
    private ReservaRepository reservaRepository;
	
	@Autowired
	private UsuarioService servicio;
	
	/**
     * Redirecciona a la página de inicio de sesión.
     *
     * @return La vista de inicio de sesión.
     */

	@GetMapping("login")
	public String iniciarSesion() {
		return "login";
	}
	
	/**
     * Redirecciona a la página de inicio.
     *
     * @return La vista de inicio.
     */
	
	@GetMapping("/")
	public String verInicio() {
		return "home";
	}
	
	/**
     * Redirecciona a la página de inicio alternativa.
     *
     * @return La vista de inicio.
     */
	
	@GetMapping("/home")
	public String verInicio2() {
		return "home";
	}
	
	/**
     * Redirecciona a la página "Acerca de nosotros".
     *
     * @return La vista "Acerca de nosotros".
     */

	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	/**
     * Redirecciona a la página del menú.
     *
     * @return La vista del menú.
     */
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	/**
     * Redirecciona a la página de reservas.
     *
     * @return La vista de reservas.
     */
	
	@GetMapping("/reserv")
	public String reserv() {
		return "reserv";
	}
	
	/**
     * Redirecciona al formulario de reservas, mostrando información del usuario autenticado.
     *
     * @param model      El modelo utilizado para enviar datos a la vista.
     * @param principal  El objeto Principal que representa al usuario autenticado.
     * @return La vista del formulario de reservas.
     */
	
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
	
	/**
     * Redirecciona al menú completo del administrador, mostrando información de usuarios y reservas.
     *
     * @param model      El modelo utilizado para enviar datos a la vista.
     * @param principal  El objeto Principal que representa al usuario autenticado.
     * @return La vista del menú completo del administrador.
     */
	
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
	
	/**
     * Mapea la operación de editar usuario por ID.
     *
     * @param id     El ID del usuario a editar.
     * @param model  El modelo utilizado para enviar datos a la vista.
     * @return La vista de edición de usuario.
     */
	
	@GetMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Long id, Model model) {
	    Usuario usuario = servicio.obtenerUsuarioPorId(id);
	    model.addAttribute("usuario", usuario);
	    return "edit";
	}
	
	/**
     * Mapea la operación de actualizar usuario.
     *
     * @param usuario El objeto Usuario a actualizar.
     * @return La redirección a la vista del menú completo.
     */

	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute Usuario usuario) {
	    servicio.actualizarUsuario(usuario);
	    return "redirect:/menufull";
	}
	
	/**
     * Mapea la operación de eliminar usuario por ID.
     *
     * @param id El ID del usuario a eliminar.
     * @return La redirección a la vista del menú completo con un indicador de éxito.
     */

	@PostMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@RequestParam Long id) {
	    servicio.eliminarUsuario(id);
	    return "redirect:/menufull?exito=true";
	}
	
	 /**
     * Mapea la operación de eliminar reserva por ID.
     *
     * @param id El ID de la reserva a eliminar.
     * @return La redirección a la vista del menú completo con un indicador de éxito.
     */
	
	@PostMapping("/eliminarReserva/{id}")
	public String eliminarReserva(@PathVariable Long id) {
	    servicio.eliminarReserva(id);
	    return "redirect:/menufull?exito=true";
	}
}
