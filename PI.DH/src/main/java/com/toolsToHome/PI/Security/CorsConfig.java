package com.toolsToHome.PI.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Permitir solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir estos métodos HTTP
                .allowedHeaders("*"); // Permitir todos los encabezados
        registry.addMapping("/auth/register")
                .allowedOrigins("http://localhost:5173/auth/register")


                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("*");
        registry.addMapping("/Herramientas/**")
                .allowedOrigins("http://localhost:5173/Herramientas/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("*");

        registry.addMapping("/user/**")
                .allowedOrigins("http://localhost:5173/user/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("*");
    }
}
