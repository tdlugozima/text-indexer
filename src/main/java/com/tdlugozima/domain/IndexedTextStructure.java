package com.tdlugozima.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IndexedTextStructure {
    private final Map<Character, List<String>> indexedText;

    public IndexedTextStructure(Map<Character, List<String>> characterListMap) {
        this.indexedText = characterListMap;
    }

    @Override
    public String toString() {
        return this.indexedText.entrySet().stream()
                .map(e -> String.format("%s: %s", e.getKey(), e.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
