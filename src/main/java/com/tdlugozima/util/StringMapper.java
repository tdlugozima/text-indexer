package com.tdlugozima.util;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class StringMapper {
    private StringMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Set<String> extractValidWordsOnly(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(removeNonAlphanumericCharacters())
                .map(String::toLowerCase)
                .filter(nonEmptyString())
                .collect(toSet());
    }

    private static Function<String, String> removeNonAlphanumericCharacters() {
        return w -> w.replaceAll("[^a-zA-Z']", "");
    }

    private static Predicate<String> nonEmptyString() {
        return e -> !e.trim().equals("");
    }
}
