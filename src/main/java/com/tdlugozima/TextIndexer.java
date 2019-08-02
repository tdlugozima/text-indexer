package com.tdlugozima;

import java.util.*;

import static com.tdlugozima.util.StringMapper.nonEmptyString;
import static com.tdlugozima.util.StringMapper.removeNonAlphanumericCharacters;
import static java.util.stream.Collectors.toSet;

public class TextIndexer {

    public static Map<Character, List<String>> indexContent(String input) {
        Set<String> allWords = Arrays.stream(input.split("\\s+"))
                .map(removeNonAlphanumericCharacters())
                .map(String::toLowerCase)
                .filter(nonEmptyString())
                .collect(toSet());

        if (allWords.isEmpty())
            return Collections.emptyMap();

        Map<Character, List<String>> indexedStructure = new HashMap<>();
        for (String word : allWords) {
            for (Character character : word.toCharArray()) {
                if (indexedStructure.containsKey(character)) {
                    List<String> elements = indexedStructure.get(character);
                    if (!elements.contains(word)) {
                        elements.add(word);
                        Collections.sort(elements);
                    }
                } else {
                    indexedStructure.put(character, new ArrayList<>(Arrays.asList(word)));
                }
            }
        }
        return indexedStructure;
    }

    private TextIndexer() {
        throw new IllegalStateException("Utility class");
    }
}
