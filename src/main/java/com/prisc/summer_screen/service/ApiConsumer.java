package com.prisc.summer_screen.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * A simple API consumer that fetches data from a given URL using Java's HttpClient.
 */
public class ApiConsumer {

    /**
     * Sends an HTTP GET request to the specified URL and returns the response body as a String.
     *
     * @param path The URL to send the request to.
     * @return The response body as a String.
     * @throws RuntimeException If an IOException or InterruptedException occurs during the request.
     */
    public String getData(String path){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .build();
        HttpResponse<String> response =  null;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}
