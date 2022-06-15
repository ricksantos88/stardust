package com.consumer.swapi.stardust.domain.repository;

import com.consumer.swapi.stardust.domain.entities.Movie;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,  Long>{

    @Query("SELECT m " +
            "FROM Movie m " +
            "WHERE m.episode = :episode")
    Optional<Movie> findByEpisode(@Param("episode") Long episode);
}
