package com.prisc.summer_screen.service;

public class OmdbApiConsumer extends ApiConsumer {
    public String getData(String title){
        title = title.replace(" ", "+");
        String endpoint = "https://www.omdbapi.com/?t=" +
                title +
                "&apikey=311191c4";
      return super.getData(endpoint);
    }
}
