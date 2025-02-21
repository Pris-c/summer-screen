package com.prisc.summer_screen.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A record representing information about a TV series.
 * This class is used to map JSON responses from the OMDb API.
 *
 * @param title       The title of the series, mapped from the JSON field "Title".
 * @param totalSeasons The total number of seasons in the series.
 * @param rating      The IMDb rating of the series, mapped from the JSON field "imdbRating".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesInfo(
        @JsonAlias("Title") String title,
        Integer totalSeasons,
        @JsonAlias("imdbRating") String rating
){}
