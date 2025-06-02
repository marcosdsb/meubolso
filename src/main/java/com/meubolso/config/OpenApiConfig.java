package com.meubolso.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Meu Bolso API",
                version = "1.0.0",
                description = "API REST para controle financeiro pessoal",
                contact = @Contact(name = "Marcos Barbosa", email = "marcos.msb@gmail.com"),
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        )
)
@Configuration
public class OpenApiConfig {
}
