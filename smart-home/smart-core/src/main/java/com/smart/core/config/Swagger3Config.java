package com.smart.core.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lico-Tom
 * 2023/11/4 23:02
 * @version V1.0
 */
@Configuration
public class Swagger3Config {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("smart home")
                        .description("smart home api doc")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("项目API文档")
                        .url(""));
    }
}
