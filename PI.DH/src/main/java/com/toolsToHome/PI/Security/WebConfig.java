package com.toolsToHome.PI.Security;

import com.toolsToHome.PI.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




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
                        .csrf(csrf ->
                                csrf
                                        .disable())
                        .cors(cors ->
                                cors
                                        .disable())
                        .authorizeHttpRequests( authRequest ->
                                        authRequest
                                                /* RUTAS PUBLICAS */
                                                .requestMatchers("/swagger-ui/**", "/swagger-resources/*", "/v3/api-docs/**", "/auth/**",
                                                        "/Herramientas/list", "/Herramientas/list/**", "/Herramientas/buscar/**",
                                                        "/Reseñas/list", "/Reseñas/list/**",
                                                        "/Categorias/list", "/Categorias/list/**",
                                                        "/Caraceristicas/list", "/Catacteristicas/list/**").permitAll()

                                                /* RUTAS PARA FAVORITOS */
                                                .requestMatchers(HttpMethod.POST, "/User/*/favs/*").authenticated()
                                                .requestMatchers(HttpMethod.GET, "/User/*/favs").authenticated()
                                                .requestMatchers(HttpMethod.DELETE, "/User/*/favs/*").authenticated()

                                                /* RUTAS PROTEGIDAS */
                                                .requestMatchers(HttpMethod.GET, "/User/profile").authenticated()
                                                .requestMatchers(HttpMethod.POST, "/Reseñas/create").hasAnyRole("ADMIN", "SUPERADMIN")
                                                .requestMatchers(HttpMethod.POST, "/Reservas/create").hasAnyRole("USER", "ADMIN", "SUPERADMIN")

                                                /* RUTAS DE ADMINISTRACIÓN */
                                                .requestMatchers("/Herramientas/create/**", "/Herramientas/delete/**",
                                                        "/Herramientas/update/**",
                                                        "/Reservas/list", "/Reservas/list/**", "/Reservas/delete/**",
                                                        "/Categorias/create/**", "/Categorias/delete/**", "/Categorias/update",
                                                        "/Caracteristicas/update", "/Caracteristicas/delete/**", "/Caracteristicas/create",
                                                        "/User/list", "/User/list/**", "/User/delete/**")
                                                .hasAnyRole("ADMIN","SUPERADMIN")

                                                /* RUTAS DEL SUPERADMIN */
                                                .requestMatchers("/User/updateRole/**").hasRole("SUPERADMIN")
                                                .anyRequest().authenticated()
                        )
                        .sessionManagement(sessionManager ->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .authenticationProvider(daoAuthenticationProvider())
                        .addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class)
                        .build();




    }


    /*
                http
                        .csrf(csrf ->
                                csrf
                                        .disable())
                        .cors(cors ->
                                cors
                                        .disable())

                        .authorizeHttpRequests( authRequest ->
                                authRequest

                                        .requestMatchers("/auth/*", "/detail/*","/registro").permitAll()
                                        .requestMatchers("/Herramientas/**").permitAll()
                                        .requestMatchers("/admin", "/categoria/**").permitAll()
                                        .requestMatchers("/user/**", "/user/{id}/usuarioRole").permitAll()
                                        .requestMatchers("/Categorias/**").permitAll()
                                        .requestMatchers("/Caracteristicas/**").permitAll()
                                        .requestMatchers("/v2/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs/**").permitAll()

                                        .anyRequest().authenticated()
                        )
                        .sessionManagement(sessionManager ->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                        )
                        .authenticationProvider(daoAuthenticationProvider())
                        .addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class)

                        .build();
*/





    /*public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return
                http
                        .csrf(AbstractHttpConfigurer::disable)
                        .cors(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests( authRequest ->
                                authRequest
                                        .requestMatchers("/v2/api-docs", "/swagger-ui/**", "/swagger-resources/**").permitAll()
                                        .requestMatchers("/auth/**", "/Herramientas/**", "/admin/**", "/user/**", "/Categorias/**", "/Caracteristicas/**", "/Reservas/**").permitAll()
                                        //.anyRequest().authenticated()
                        )
                        .sessionManagement(sessionManager ->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .authenticationProvider(daoAuthenticationProvider())
                        .addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class)
                        .build();
    }*/
    /*@Bean
    public void addCorsMappings(Cors registry) {
        registry.allowedOriginPatterns("/**")
                .codePoints("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }*/
/*
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")
                .allowCredentials(true)

                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("Access-Control-Allow-Origin");


        registry.addMapping("/auth/**")
                .allowedOrigins("http://localhost:5173/")


                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("Access-Control-Allow-Origin");


    }*/

}

/*
* return http
                .csrf(csrf ->
                        csrf
                                .disable())
                .authorizeHttpRequests( authRequest ->
                        authRequest
                                .requestMatchers("/", "/auth/*", "/detail/*").permitAll()
                                .requestMatchers("/admin", "/categoria/**").hasAnyRole("ADMIN", "SUPERADMIN")
                                .requestMatchers("/users/**").hasRole("SUPERADMIN")
                                .anyRequest().authenticated()
                        )
                .sessionManagement( sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    } */

    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}*/