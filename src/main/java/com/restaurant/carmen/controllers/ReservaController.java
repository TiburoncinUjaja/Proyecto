package com.restaurant.carmen.controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.carmen.models.Reserva;
import com.restaurant.carmen.models.Usuario;
import com.restaurant.carmen.repository.ReservaRepository;
import com.restaurant.carmen.service.UsuarioService;

/**
 * Controlador para gestionar las operaciones relacionadas con la realización de reservas en la aplicación Carmen.
 */

@Controller
public class ReservaController {
	
	@Autowired
    private UsuarioService usuarioService;
	
	@Autowired
    private ReservaRepository reservaRepository;
	
	/**
     * Realiza una reserva con la información proporcionada y el usuario autenticado.
     *
     * @param fecha           La fecha de la reserva.
     * @param hora            La hora de la reserva.
     * @param cantidadPersonas La cantidad de personas para la reserva.
     * @param principal       El objeto Principal que representa al usuario autenticado.
     * @return La redirección al formulario de reservas con un indicador de éxito.
     */

    @PostMapping("/formreserv")
    public String realizarReserva(@RequestParam("fecha") LocalDate fecha,
                                  @RequestParam("hora") LocalTime hora,
                                  @RequestParam("cantidadPersonas") int cantidadPersonas,
                                  Principal principal) {
        // Obtener el usuario actual
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());

        // Crear una nueva reserva
        Reserva reserva = new Reserva();
        reserva.setFecha(fecha);
        reserva.setHora(hora);
        reserva.setCantidadPersonas(cantidadPersonas);
        reserva.setUsuario(usuario);

        // Guardar la reserva en la base de datos
        reservaRepository.save(reserva);

        return "redirect:/formreserv?exito=true"; // redirigir después de hacer la reserva
    }
}

