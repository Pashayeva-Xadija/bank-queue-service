package com.queue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${cors.allowed-origins:*}")
    private String allowed;

    @Bean
    public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();

        String[] arr = allowed.split(",");
        boolean wildcard = java.util.Arrays.stream(arr)
                .anyMatch(s -> s.trim().equals("*"));

        if (wildcard) {
            cfg.addAllowedOriginPattern("*");
            cfg.setAllowCredentials(false);
        } else {
            cfg.setAllowedOrigins(java.util.List.of(arr));
            cfg.setAllowCredentials(true);
        }

        cfg.setAllowedMethods(java.util.List.of("GET","POST","PUT","DELETE","OPTIONS"));
        cfg.addAllowedHeader("*");
        cfg.addExposedHeader("Authorization");

        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**", cfg);
        return src;
    }
}
