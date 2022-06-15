package com.consumer.swapi.stardust.clients.swapi;

import com.consumer.swapi.stardust.clients.swapi.DTO.StarWarsResponseDTO;
import com.consumer.swapi.stardust.infrastructure.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = FeignConfig.STAR_WARS_API_CLIENT, url = "https://swapi.dev/api/", decode404 = true)
public interface StarWarsAPIServiceClient {

    String GET_SWAPI_MOVIES_ENDPOINT = "films/?format=json";

    @GetMapping(GET_SWAPI_MOVIES_ENDPOINT)
    StarWarsResponseDTO searchAllStarWarsMovies();

}
