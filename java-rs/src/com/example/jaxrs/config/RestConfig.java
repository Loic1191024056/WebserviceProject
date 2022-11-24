package com.example.jaxrs.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @since Created at 2022-11-23 15:40
 */
public class RestConfig  extends ResourceConfig {
    public RestConfig() {
        packages("com.example.jaxrs");
    }
}
