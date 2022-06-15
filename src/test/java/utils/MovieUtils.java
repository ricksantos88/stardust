package utils;

import com.consumer.swapi.stardust.domain.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieUtils {

    public List<Movie> returnListOfMovies() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        movie1.setId(1L);
        movie2.setId(2L);
        movie3.setId(3L);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        return movieList;
    }

}
