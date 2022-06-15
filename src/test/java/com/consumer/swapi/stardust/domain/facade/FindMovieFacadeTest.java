package com.consumer.swapi.stardust.domain.facade;

import com.consumer.swapi.stardust.domain.entities.Movie;
import com.consumer.swapi.stardust.domain.service.impl.MovieService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import utils.MovieUtils;

import java.util.List;

import static org.mockito.BDDMockito.given;

class FindMovieFacadeTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private FindMovieFacade searchLeadFacade;

    @Test
    @DisplayName("should find allMovies")
    void shouldFindAllMovies() {

        given(movieService.findAllMovies()).willReturn(new MovieUtils().returnListOfMovies());

        List<Movie> allMovies = searchLeadFacade.findAllMovies();

        Assertions.assertThat(allMovies).isNotEmpty();

    }

}