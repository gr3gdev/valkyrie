package com.github.gr3gdev.valkyrie.config;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Configuration
public class FaviconConfiguration {

    @Bean
    SimpleUrlHandlerMapping customFaviconHandlerMapping() {
        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Integer.MIN_VALUE);
        mapping.setUrlMap(Map.of("/favicon.ico", faviconRequestHandler()));
        return mapping;
    }

    @Bean
    ResourceHttpRequestHandler faviconRequestHandler() {
        final ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
        final ClassPathResource classPathResource = new ClassPathResource("static/");
        requestHandler.setLocations(List.of(classPathResource));
        return requestHandler;
    }
}
