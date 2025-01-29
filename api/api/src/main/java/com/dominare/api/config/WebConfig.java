package com.dominare.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class WebConfig {
    
    @Bean
    // método para fazer o springBoot ler métodos diferentes de !post !get
    // Por padrão o SpringBoot não ler métodos como put e delete. O HTML só tem semantica para métodos !post !get 
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
