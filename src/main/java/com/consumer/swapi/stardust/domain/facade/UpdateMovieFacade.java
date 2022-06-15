package com.consumer.swapi.stardust.domain.facade;

import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.exception.MovieSearchException;
import com.consumer.swapi.stardust.domain.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateMovieFacade {

    private final IMovieService movieService;

    public void updateMovie(Movie movieToUpdate) {
        Movie movieSaved = movieService.findMovie(movieToUpdate.getId())
                .orElseThrow(() -> new MovieSearchException("Movie not found because id "+ movieToUpdate.getId() + " not saved in DB"));

        movieSaved.setOpeningCrawl(movieToUpdate.getOpeningCrawl());
        movieService.persistMovie(movieSaved);
    }

}
