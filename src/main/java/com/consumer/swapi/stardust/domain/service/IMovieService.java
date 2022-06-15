package com.consumer.swapi.stardust.domain.service;

import com.consumer.swapi.stardust.domain.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService extends BaseService<Movie> {

    void saveAllMovies(List<Movie> movies);

    Optional<Movie> findMovieByEpisode(Long episode);

}
