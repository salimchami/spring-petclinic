package com.occitane.petclinic.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.joining;

public final class JsonReader {

    private JsonReader() {
        // not accessible constructor
    }

	public static String toExpectedJson(String folder, String fileName) {
        return toJson("expected-data", folder, fileName);
    }

    private static String toJson(String baseFolder, String folder, String fileName) {
        var jsonFile = String.format("%s/%s/%s.json", baseFolder, folder, fileName);
        var jsonUrl = JsonReader.class.getClassLoader().getResource(jsonFile);
        if (jsonUrl == null) {
            throw new IllegalArgumentException(String.format("File %s not found", jsonFile));
        }
        try (Stream<String> stream = lines(get(jsonUrl.toURI()))) {
            return stream.collect(joining());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException(String.format("File %s not found", jsonFile));
        }
    }
}
