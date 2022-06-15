package com.consumer.swapi.stardust.domain.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    T persistMovie(T t);

    List<T> findAllMovies();

    Optional<T> findMovie(Long id);

}
