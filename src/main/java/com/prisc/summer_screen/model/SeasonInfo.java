package com.prisc.summer_screen.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * A record representing information about a TV series season.
 * This class is used to map JSON responses from the OMDb API.
 *
 * @param season   The season number, mapped from the JSON field "Season".
 * @param episodes The list of episodes in the season, mapped from the JSON field "Episodes".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonInfo(
        @JsonAlias("Season")  Integer season,
        @JsonAlias("Episodes") List<EpisodeInfo> episodes
) {}
