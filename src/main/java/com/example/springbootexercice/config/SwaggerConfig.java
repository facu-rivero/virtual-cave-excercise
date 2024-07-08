package com.example.springbootexercice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Configuracion Swagger para la generacion de documentacion de la API REST
* http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDetails() {
        return new OpenAPI().info(new Info()
                .title("Rates API REST")
                .version("1.0")
                .description("Libreria Swagger de Api Rates")
                .contact(new Contact().name("Facundo Rivero").email("frr.1991@gmail.com"))
                .license(new License().name("License")));
    }
}
