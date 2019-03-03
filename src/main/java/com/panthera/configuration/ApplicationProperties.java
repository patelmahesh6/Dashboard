/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 *
 * @author Mahesh
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    @Getter
    private final CorsConfiguration cors = new CorsConfiguration();

    @Getter
    private final Mail mail = new Mail();

    @Getter
    private final Async async = new Async();

    @Getter
    @Setter
    public static class Mail {

        private boolean enabled;
        private String from;
        private String baseUrl;

    }

    @Getter
    @Setter
    public static class Async {

        private int corePoolSize = 2;
        private int maxPoolSize = 10;
        private int queueCapacity = 1000;

    }

}
