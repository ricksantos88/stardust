package com.consumer.swapi.stardust.controllers;

import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.facade.FindMovieFacade;
import com.consumer.swapi.stardust.domain.facade.UpdateMovieFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    public static final String BASE_URL = "/movie";
    public static final String GET_FIND_BY_ID_URL = BASE_URL + "/{id}";
    public static final String GET_FIND_BY_EPISODE_URL = BASE_URL + "/episode/{episode}";
    public static final String PUT_UPDATE_BY_ID =  BASE_URL + "/{id}";
    public static final String POST_CREATE_MOVIE = BASE_URL;

    private final FindMovieFacade findMovieFacade;
    private final UpdateMovieFacade updateMovieFacade;

    @GetMapping(BASE_URL)
    public List<Movie> findAllMovies() {
        return findMovieFacade.findAllMovies();
    }

    @GetMapping(GET_FIND_BY_ID_URL)
    public Movie findMovieById(@PathVariable Long id) {
        return findMovieFacade.findMovieById(id);
    }

    @GetMapping(GET_FIND_BY_EPISODE_URL)
    public Movie findMovieByEpisode(@PathVariable Long episode) {
        return findMovieFacade.findMovieByEpisode(episode);
    }

    @PutMapping(PUT_UPDATE_BY_ID)
    public void update(@PathVariable Long id, @Validated @RequestBody Movie movie) {
        updateMovieFacade.updateMovie(movie);
    }

}
