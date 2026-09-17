package dev.java10x.ItauJava10x.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Desafio ITAU")
                                .description("API para gerenciamento e consulta de transações")
                                .version("1.0.0")
                );
    }


}
