package com.example.clientservice.config;

import com.example.clientservice.listconst.ListUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConf {
    @Bean
    public WebClient webClient(WebClient.Builder webClient){
        return webClient.baseUrl(ListUrl.URL_WEB_CLIENT)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
