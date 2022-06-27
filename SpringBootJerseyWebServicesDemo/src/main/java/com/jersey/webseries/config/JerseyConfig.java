package com.jersey.webseries.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.jersey.webseries.service.UserService;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserService.class);
    }
}