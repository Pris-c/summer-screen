package com.prisc.summer_screen.service;

import com.prisc.summer_screen.model.EpisodeInfo;
import com.prisc.summer_screen.model.SeasonInfo;
import com.prisc.summer_screen.model.SeriesInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A specialized API consumer for fetching movie data from the OMDb API.
 * Extends {@link ApiConsumer} to reuse its HTTP request functionality.
 */
public class OmdbApiConsumer extends ApiConsumer {

    private final String apiKey = "311191c4";
    private final DataConverter mapper = new DataConverter();

    /**
     * Fetches information about a TV series from the OMDb API.
     *
     * @param title The title of the TV series.
     * @return A {@link SeriesInfo} object containing details about the series.
     * @throws RuntimeException If an error occurs while fetching or processing the data.
     */
    public SeriesInfo getSeriesInfo(String title){
        title = title.replace(" ", "+");
        String endpoint = "https://www.omdbapi.com/?t=" + title +
                "&apikey=" + apiKey;
      var serieInfo = super.getData(endpoint);
      return mapper.jsonToObject(serieInfo, SeriesInfo.class);
    }

    /**
     * Fetches information about a specific season of a TV series.
     *
     * @param title  The title of the TV series.
     * @param season The season number.
     * @return A {@link SeasonInfo} object containing details about the specified season.
     * @throws RuntimeException If an error occurs while fetching or processing the data.
     */
    public SeasonInfo getSeasonInfo(String title, Integer season){
        title = title.replace(" ", "+");
        String endpoint = "https://www.omdbapi.com/?t=" + title +
                "&season=" + season +
                "&apikey=" + apiKey;
        var seasonInfo = super.getData(endpoint);
        return mapper.jsonToObject(seasonInfo, SeasonInfo.class);
    }

    /**
     * Fetches information about a specific episode of a TV series.
     *
     * @param title   The title of the TV series.
     * @param season  The season number.
     * @param episode The episode number.
     * @return An {@link EpisodeInfo} object containing details about the specified episode.
     * @throws RuntimeException If an error occurs while fetching or processing the data.
     */
    public EpisodeInfo getEpisodeInfo(String title, Integer season, Integer episode){
        title = title.replace(" ", "+");
        String endpoint = "https://www.omdbapi.com/?t=" + title +
                "&season=" + season +
                "&episode=" + episode +
                "&apikey=" + apiKey;
        var episodeInfo = super.getData(endpoint);
        return mapper.jsonToObject(episodeInfo, EpisodeInfo.class);
    }

    /**
     * Fetches information about all seasons of a TV series, including all episodes.
     *
     * @param title The title of the TV series.
     * @return A list of {@link SeasonInfo} objects containing details about all seasons.
     * @throws RuntimeException If an error occurs while fetching or processing the data.
     */
    public List<SeasonInfo> getAllEpisodesInfo(String title){
        List<SeasonInfo> allSerieEpisodes = new ArrayList<>();
        var serieInfo = this.getSeriesInfo(title);

        for(int i = 1; i <= serieInfo.totalSeasons(); i++){
            allSerieEpisodes.add(this.getSeasonInfo(title, i));
        }
        return allSerieEpisodes;
    }

}
