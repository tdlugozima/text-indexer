package com.tdlugozima;

import com.tdlugozima.util.StringMapper;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class TextIndexer {
    private TextIndexer() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<Character, List<String>> indexContent(String input) {
        Set<String> allWords = StringMapper.extractValidWordsOnly(input);

        if (allWords.isEmpty())
            return Collections.emptyMap();

        Map<Character, List<String>> indexedStructure = new HashMap<>();
        for (String word : allWords) {
            for (Character character : setWithoutDuplicatedCharacters(word)) {
                if (!indexedStructure.containsKey(character)) {
                    createNewEntryForGivenCharacterAndWord(indexedStructure, word, character);
                } else {
                    updateWordListForGivenCharacter(indexedStructure, word, character);
                }
            }
        }
        return indexedStructure;
    }

    private static Set<Character> setWithoutDuplicatedCharacters(String word) {
        return word.chars().mapToObj(v -> Character.valueOf((char) v)).collect(toSet());
    }

    private static void createNewEntryForGivenCharacterAndWord(Map<Character, List<String>> indexedStructure, String word, Character character) {
        indexedStructure.put(character, new ArrayList<>(Arrays.asList(word)));
    }

    private static void updateWordListForGivenCharacter(Map<Character, List<String>> indexedStructure, String word, Character character) {
        List<String> elements = indexedStructure.get(character);
        if (!elements.contains(word)) {
            elements.add(word);
            Collections.sort(elements);
        }
    }
}
