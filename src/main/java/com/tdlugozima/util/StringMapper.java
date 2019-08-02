package com.tdlugozima.util;

import java.util.function.Function;
import java.util.function.Predicate;

public class StringMapper {
    private StringMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Function<String, String> removeNonAlphanumericCharacters() {
        return w -> w.replaceAll("[^a-zA-Z']", "");
    }

    public static Predicate<String> nonEmptyString() {
        return e -> !e.trim().equals("");
    }
}
