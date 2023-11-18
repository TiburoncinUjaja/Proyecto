package com.restaurant.carmen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.restaurant.carmen.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    @Lazy
    private UsuarioService usuarioService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                        		.requestMatchers(
                        				HttpMethod.GET,"/menufull", "/users", "/edit").hasRole("ADMIN")
                                // Permite acceso a las rutas de documentos HTML sin autenticación
                                .requestMatchers(
                                        HttpMethod.GET, "/", "/login**", "/registro**", "/home**", "/about**", "/menu**", "/reserv**", "/usuarios/**").permitAll()
                                // Permite acceso a las rutas de recursos estáticos (CSS, JS, imágenes, etc.)
                                .requestMatchers(
                                        HttpMethod.GET, "/css/**", "/js/**", "/Source/**").permitAll()
                                .requestMatchers(
                                        HttpMethod.POST, "/registro", "/login").permitAll()
                                // Restringe el acceso a otras rutas a usuarios autenticados
                                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/formreserv", true)
                        .permitAll()
                )
                .logout(logout -> logout
                		.logoutUrl("/logout") // Especifica la URL de cierre de sesión
                        .logoutSuccessUrl("/login?logout") // URL a la que redirigir después de cerrar sesión
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID") // Elimina las cookies de sesión
                        .permitAll()
                )
                .build();
    }
}
