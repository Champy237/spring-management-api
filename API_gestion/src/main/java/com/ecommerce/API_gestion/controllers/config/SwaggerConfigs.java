package com.ecommerce.API_gestion.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfigs {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de e-commerce")
                        .description("Projet backend e-commerce - Propenta Tech")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Ndjong Cedric Allan")
                                .email("allan.ndjong@facsciences-uy1.cm")
                        )
                );
    }
}
