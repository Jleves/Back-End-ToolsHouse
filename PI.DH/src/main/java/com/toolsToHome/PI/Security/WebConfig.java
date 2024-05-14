package com.toolsToHome.PI.Security;

import com.toolsToHome.PI.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class WebConfig  {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return
                http
                        .cors(c -> c.configurationSource(corsConfigurationSource()))
                        .exceptionHandling(customizer -> customizer.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                        .csrf(AbstractHttpConfigurer::disable)
                        .sessionManagement(sessionManager ->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .authorizeHttpRequests( authRequest ->
                                        authRequest /* RUTAS PUBLICAS */
                                                .requestMatchers(HttpMethod.POST,"/auth/login", "/auth/register").permitAll()
                                                .requestMatchers(HttpMethod.POST,"/Reservas/create","/Reseñas/create","/User/favs/**").hasAnyRole("USER","ADMIN","SUPERADMIN")
                                                .requestMatchers(HttpMethod.POST, "/Caracteristicas/create","/Categorias/create", "/Herramientas/create" ).hasAnyRole("ADMIN","SUPERADMIN")
                                                .requestMatchers(HttpMethod.GET,"/Caracteristicas/list","/Caracteristicas/list/**","/Categorias/list","/Categorias/list/**","/Herramientas/list", "/Herramientas/list/**", "/Herramientas/buscar/nombre/**","/Herramientas/buscar/**","/Reseñas/list","/Reseñas/list/**", "/Reseñas/herramienta/**").permitAll()
                                                .requestMatchers(HttpMethod.GET, "/Reservas/list" ,"/Reservas/list/**", "/User/profile","User/favs/**").hasAnyRole("USER","SUPERADMIN","ADMIN")
                                                .requestMatchers(HttpMethod.GET,"User/list").hasAnyRole("ADMIN","SUPERADMIN")
                                                .requestMatchers(HttpMethod.PUT, "/Caracteristicas/update","/Categorias/update","/Herramientas/update","/User/updateRole/**").hasAnyRole("ADMIN", "SUPERADMIN")
                                                .requestMatchers(HttpMethod.DELETE,"/Reservas/delete/**", "/Reseñas/delete/**").hasAnyRole("USER","SUPERADMIN","ADMIN")
                                                .requestMatchers(HttpMethod.DELETE, "/Caracteristicas/delete/**","/Categorias/delete/**","/Herramientas/delete/**").hasAnyRole("ADMIN", "SUPERADMIN")


                                                .anyRequest().authenticated()
                        )

                        .authenticationProvider(daoAuthenticationProvider())
                        .addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class)
                        .build();




    }



}

