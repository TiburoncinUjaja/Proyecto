package com.restaurant.carmen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {
	
    @GetMapping("/")
    public String home(Model model) {
        // Lógica adicional si es necesaria
        return "home"; // Nombre de tu archivo HTML (sin la extensión .html)
    }

    @GetMapping("/home")
    public String home1(Model model) {
        // Lógica adicional si es necesaria
        return "home"; // Nombre de tu archivo HTML (sin la extensión .html)
    }

    @GetMapping("/reserv")
    public String reserv(Model model) {
        // Lógica adicional si es necesaria
        return "reserv";
    }

    @GetMapping("/about")
    public String about(Model model) {
        // Lógica adicional si es necesaria
        return "about";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        // Lógica adicional si es necesaria
        return "menu";
    }
    

    
}
