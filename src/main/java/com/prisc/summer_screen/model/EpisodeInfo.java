package com.prisc.summer_screen.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A record representing information about a specific episode of a TV series.
 * This class is used to map JSON responses, typically from sources like the OMDb API.
 *
 * @param title      The title of the episode, mapped from the JSON field "Title".
 * @param episode    The episode number, mapped from the JSON field "Episode".
 * @param rating     The IMDb rating of the episode, mapped from the JSON field "imdbRating".
 * @param releaseDate The release date of the episode, mapped from the JSON field "Released".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeInfo(
        @JsonAlias("Title") String title,
        @JsonAlias("Episode")Integer episode,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Released") String releaseDate
) {}
