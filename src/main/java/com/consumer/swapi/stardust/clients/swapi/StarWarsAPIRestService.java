package com.consumer.swapi.stardust.clients.swapi;

import com.consumer.swapi.stardust.clients.swapi.DTO.StarWarsResponseDTO;
import com.consumer.swapi.stardust.domain.exception.ClientCallException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StarWarsAPIRestService {

    private final StarWarsAPIServiceClient starWarsAPIServiceClient;

    public StarWarsResponseDTO findAllStarWarsMovies() {

        log.info("M=findAllStarWarsMovies, message=Init searching all movies of star wars.");
        try {
            final StarWarsResponseDTO starWarsResponseDTO = starWarsAPIServiceClient.searchAllStarWarsMovies();
            if (starWarsResponseDTO == null) {
                log.info("M=findAllStarWarsMovies, message=search found no movies");
                return new StarWarsResponseDTO();
            }
            return starWarsResponseDTO;

        } catch (FeignException e) {
            log.info("M=findAllStarWarsMovies, message=Error searching document all movies of star wars on service, resp={}", e.contentUTF8(), e);
            throw new ClientCallException("Error connecting to server.");
        }
    }

}
