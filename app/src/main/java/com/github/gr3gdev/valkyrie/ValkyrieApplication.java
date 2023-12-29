package com.github.gr3gdev.valkyrie;

import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValkyrieApplication {

    public static void main(String[] args) {
        //System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(ValkyrieApplication.class, args);
    }

    @Bean
    UndertowDeploymentInfoCustomizer undertowDeploymentInfoCustomizer() {
        return deploymentInfo -> deploymentInfo.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    }
}
