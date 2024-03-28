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
                .allowedOrigins("http://localhost:5173/**")
                .allowedMethods("*")
                .allowedHeaders("*");

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");

        registry.addMapping("http://localhost:8080/swagger-ui.html")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");

    }
}
