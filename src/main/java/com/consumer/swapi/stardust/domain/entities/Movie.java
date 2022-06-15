package com.consumer.swapi.stardust.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = Movie.TABLE_NAME)
public class Movie extends BaseModel {

    protected static final String TABLE_NAME = "MOVIE";

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private Long episode;

    @Column
    private String director;

    @Column
    private String producer;

    @Column
    private LocalDate releaseDate;

    @Column(length = 5000)
    private String openingCrawl;

    @Column(name = "urlswapi")
    private String url;

}
