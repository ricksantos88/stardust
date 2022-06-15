package com.consumer.swapi.stardust.domain.service.impl;

import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.repository.MovieRepository;
import com.consumer.swapi.stardust.domain.service.IMovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    private final MovieRepository repository;

    @Override
    public Movie persistMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> findMovie(Long id) {
        return repository.findById(id);
    }


    @Override
    public void saveAllMovies(List<Movie> movies) {
        repository.saveAll(movies);
    }

    @Override
    public Optional<Movie> findMovieByEpisode(Long episode) {
        return repository.findByEpisode(episode);
    }
}
