package com.walearn.platform.backend.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                description = "Open API documentation for EntryGenius Web Application that streamline access control " +
                        "and enhance security for gated communities and residential compounds.",
                title = "EntryGenius web Application",
                contact = @Contact(name = "Olawale Agboola",
                        email = "agboolawale8@gmail.com",
                        url = "https://www.github.com/Realwale"),
                version = "1.0",
                license = @License(name = "Apache License", url = "https://www.apache.org/licenses/LICENSE-2"),
                termsOfService = "Terms of Service"
        )
)
public class SwaggerConfig {
}