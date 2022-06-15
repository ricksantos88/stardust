package com.consumer.swapi.stardust.infrastructure;

import com.consumer.swapi.stardust.clients.swapi.DTO.StarWarsMovieDTO;
import com.consumer.swapi.stardust.clients.swapi.StarWarsAPIServiceClient;
import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.service.impl.MovieService;
import com.consumer.swapi.stardust.utils.ConverterMovieDTOToEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Slf4j
@Profile("test")
@RequiredArgsConstructor
public class Loader implements CommandLineRunner {

    private final StarWarsAPIServiceClient starWarsAPIServiceClient;
    private final MovieService movieService;

    @Override
    public void run(String... args) throws Exception {

        List<StarWarsMovieDTO> results = starWarsAPIServiceClient.searchAllStarWarsMovies().getResults();
        log.info("quantity of movies={}", results.size());
        log.info("saving movies on base");

        ConverterMovieDTOToEntity converter = new ConverterMovieDTOToEntity();
        results.sort((o1, o2) -> o1.getEpisode() - o2.getEpisode());
        results.forEach(dto -> {
            log.info("episode={}, movie name={}", dto.getEpisode(), dto.getTitle());
            Movie movie = movieService.persistMovie(converter.convertDTOToEntity(dto));
            log.info("movie saved, id={}, name={}", movie.getId(), movie.getTitle());
        });

    }
}
