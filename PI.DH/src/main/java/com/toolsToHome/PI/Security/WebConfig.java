package com.toolsToHome.PI.Security;

import com.toolsToHome.PI.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebConfig(UsuarioService usuarioService, JwtUtil jwtUtil, JwtRequestFilter jwtRequestFilter, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.jwtRequestFilter = jwtRequestFilter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public WebConfig(boolean disableDefaults, UsuarioService usuarioService, JwtUtil jwtUtil, JwtRequestFilter jwtRequestFilter, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(disableDefaults);
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.jwtRequestFilter = jwtRequestFilter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()

                .csrf(csrf ->
                        csrf
                                .disable())

                .authorizeHttpRequests( authRequest ->
                        authRequest

                                .antMatchers("/auth/*", "/detail/*","/registro").permitAll()
                                .antMatchers("/Herramientas/**").permitAll()
                                .antMatchers("/admin", "/categoria/**").permitAll()
                                .antMatchers("/users/**").hasAnyRole("SUPERADMIN","USER","ADMIN")
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
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {




        return


                http
                        .cors().and()

                        .csrf(csrf ->
                                csrf
                                        .disable())

                        .authorizeHttpRequests( authRequest ->
                                authRequest

                                        .requestMatchers("/auth/*", "/detail/*","/registro").permitAll()
                                        .requestMatchers("/Herramientas/**").permitAll()
                                        .requestMatchers("/admin", "/categoria/**").permitAll()
                                        .requestMatchers("/users/**").hasAnyRole("SUPERADMIN","USER","ADMIN")
                                        .anyRequest().authenticated()
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