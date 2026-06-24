package com.example.employeecrud.config;

import com.example.employeecrud.constant.SwaggerConstants;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(SwaggerConstants.API_TITLE)
                        .version(SwaggerConstants.API_VERSION)
                        .description(SwaggerConstants.API_DESCRIPTION));
    }
}
