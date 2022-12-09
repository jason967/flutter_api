package com;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger2Config {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("v1").pathsToMatch("/api/**").build();
    }

    @Bean
    public OpenAPI shopApi() {
        return new OpenAPI().info(new Info().title("Flutter Shop API").description("e-commerce architecture flutter shop API 명세서").version("v1.0"));
    }
}
