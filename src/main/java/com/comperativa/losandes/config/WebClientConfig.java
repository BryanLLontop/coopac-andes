package com.comperativa.losandes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${spring.webclient.base-url}")
    private String urlBase;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(urlBase)
                .build();
    }
}
