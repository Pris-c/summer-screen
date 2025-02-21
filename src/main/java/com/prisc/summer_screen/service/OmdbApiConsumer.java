package com.prisc.summer_screen.service;

/**
 * A specialized API consumer for fetching movie data from the OMDb API.
 * Extends {@link ApiConsumer} to reuse its HTTP request functionality.
 */
public class OmdbApiConsumer extends ApiConsumer {

    /**
     * Fetches series or movie data from the OMDb API using the given the title.
     *
     * @param title The title of the movie or series to search for.
     * @return The JSON response from the OMDb API as a String.
     */
    public String getData(String title){
        title = title.replace(" ", "+");
        String endpoint = "https://www.omdbapi.com/?t=" +
                title +
                "&apikey=311191c4";
      return super.getData(endpoint);
    }
}
