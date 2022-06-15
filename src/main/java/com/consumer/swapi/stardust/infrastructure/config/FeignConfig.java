package com.consumer.swapi.stardust.infrastructure.config;

import com.consumer.swapi.stardust.clients.swapi.StarWarsAPIServiceClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {StarWarsAPIServiceClient.class})
public class FeignConfig {

    public static final String STAR_WARS_API_CLIENT = "StarWarsAPIServiceClient";

}
