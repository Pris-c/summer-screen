package com.prisc.summer_screen.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonInfo(
        @JsonAlias("Season")  Integer season,
        @JsonAlias("Episodes") List<EpisodeInfo> episodes
) {}
