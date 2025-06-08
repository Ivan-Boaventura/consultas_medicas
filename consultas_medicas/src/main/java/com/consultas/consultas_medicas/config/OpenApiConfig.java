package com.consultas.consultas_medicas.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	 @Bean
	    OpenAPI customOpenAPI(){
	        return new OpenAPI()
	            .info(new Info()
	                .title("Consultas Medicas")
	                    .version("v3")
	                    .description("Este projeto é um sistema de gerenciamento de consultas médicas desenvolvido em Java com Spring Boot. "
	                    		+ "Ele tem como objetivo permitir o cadastro e gerenciamento de consultas entre pacientes e médicos, com apoio de "
	                    		+ "secretárias.")
	                    .termsOfService("https://consultasM.com")
	                    .license(new License()
	                        .name("Apache 2.0")
	                        .url("https://theHumanitarianVoice.org")
	                    )
	            );
	    }

}
