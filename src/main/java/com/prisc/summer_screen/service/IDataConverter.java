package com.prisc.summer_screen.service;

/**
 * An interface for converting JSON data into Java objects.
 */
public interface IDataConverter {

    /**
     * Converts a JSON string into an object of the specified class type.
     *
     * @param json        The JSON string to be converted.
     * @param objectClass The class of the object to convert the JSON into.
     * @param <T>         The type of the object to be returned.
     * @return An instance of {@code T} populated with data from the JSON string.
     */
    <T> T jsonToObject(String json, Class<T> objectClass);
}
