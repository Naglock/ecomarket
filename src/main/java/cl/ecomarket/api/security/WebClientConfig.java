package cl.ecomarket.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient usuariosWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/api/v1/usuarios")
                .build();
    }
}