package com.consumer.swapi.stardust.utils;

import com.consumer.swapi.stardust.clients.swapi.DTO.StarWarsMovieDTO;
import com.consumer.swapi.stardust.domain.entities.Movie;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterMovieDTOToEntity {

    private final ModelMapper mapper;

    public ConverterMovieDTOToEntity() {
        mapper = new ModelMapper();
    }

    public Movie convertDTOToEntity(StarWarsMovieDTO dto) {
        return mapper.map(dto, Movie.class);
    }

    public List<Movie> convertListDTOToListMovie(List<StarWarsMovieDTO> starWarsMovieDTOS) {
        return starWarsMovieDTOS.stream().map(this::convertDTOToEntity).collect(Collectors.toList());
    }

}
