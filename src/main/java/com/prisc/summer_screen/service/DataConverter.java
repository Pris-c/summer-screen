package com.prisc.summer_screen.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A concrete implementation of the {@link IDataConverter} interface.
 * This class uses Jackson's {@link ObjectMapper} to convert JSON strings into Java objects.
 */
public class DataConverter implements  IDataConverter {

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converts a JSON string into an object of the specified class type.
     *
     * @param json        The JSON string to be converted.
     * @param objectClass The class of the object to convert the JSON into.
     * @param <T>         The type of the object to be returned.
     * @return An instance of {@code T} populated with data from the JSON string.
     * @throws RuntimeException If an error occurs while processing the JSON.
     */
    @Override
    public <T> T jsonToObject(String json, Class<T> objectClass) {
        try {
            return mapper.readValue(json, objectClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
