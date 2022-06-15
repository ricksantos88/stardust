package com.consumer.swapi.stardust.domain.facade;

import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindMovieFacade {

    private final IMovieService movieService;

    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    public Movie findMovieById(Long id) {
        return movieService
            .findMovie(id)
            .orElseThrow(() ->
                    new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Movie not found because id "+ id + " not saved in DB" ));
    }

    public Movie findMovieByEpisode(Long episode) {
        return movieService
            .findMovieByEpisode(episode)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Movie not found because episode "+ episode + " not saved in DB" ));
    }

}
