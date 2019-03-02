/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 *
 * @author Mahesh
 */
@ConfigurationProperties(prefix = "project", ignoreUnknownFields = false)
@PropertySources({
    @PropertySource(value = "classpath:project.properties", ignoreResourceNotFound = true)})
public class ProjectProperties {

}
