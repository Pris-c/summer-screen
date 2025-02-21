package com.prisc.summer_screen.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeInfo(
        @JsonAlias("Title") String title,
        @JsonAlias("Episode")Integer episode,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Released") String releaseDate
) {}
