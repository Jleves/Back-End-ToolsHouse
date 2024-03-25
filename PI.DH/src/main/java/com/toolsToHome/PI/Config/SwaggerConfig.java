package com.toolsToHome.PI.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Usuario", "Usuario Controller"))
                .tags(new Tag("Auth", "Auth Controller"))
                .tags(new Tag("Herramienta", "Herramienta Controller"))
                .tags(new Tag("Categoria", "Categoria Controller"))
                .tags(new Tag("Caracteristica", "Caracteristica Controller"))
                .tags(new Tag("Reserva", "Reserva Controller"));
    }
    private ApiKey apiKey()
    {
        return new ApiKey("JWT", "Authorization", "header");
    }
    private SecurityContext securityContext()
    {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    private List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
    private ApiInfo apiInfo()
    {
        return new ApiInfo("Toolhouse",
                "Booking desarrollado para aplicar conocimientos adquisidos durantes el primer track de CTD, Digital House.\n" +
                        "Grupo 2 \n" +
                        "   - García, Wendy\n" +
                        "   - Favaloro, Giovanni\n" +
                        "   - Leves, Jorge\n" +
                        "   - Gutierrez, Angel\n" +
                        "   - Montero, Leidy\n" +
                        "   - Lasserre, Breno\n" +
                        "   - Errasti, Joaquín\n" +
                        "   - Martínez, Gonzalo\n" +
                        "   - Álvarez, Nicolás\n" +
                        "   - Apellido, Fernando\n",
                "V.0.0.1",
                "Terms of service",
                new Contact("ToolHouse", "URL del deploy", "correco_de_contacto@example.com"),
                "Licencia",
                "licencia.com",
                Collections.emptyList());
    }
}
