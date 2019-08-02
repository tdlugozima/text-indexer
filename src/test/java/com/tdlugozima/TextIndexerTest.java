package com.tdlugozima;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TextIndexerTest {

    @Test
    public void givenWhiteCharsOrUnallowedOnly_shouldReturnEmptyMap() throws Exception {
        String input = "  - $$}";
        Map<Character, List<String>> output = TextIndexer.indexContent(input);
        assertThat(output).isEmpty();

    }

    @Test
    public void givenOneWordInput_shouldReturnCorrectOutput() throws Exception {
        String input = "ala";
        Map<Character, List<String>> output = TextIndexer.indexContent(input);
        assertThat(output).contains(
                entry(Character.valueOf('a'), Arrays.asList("ala")),
                entry(Character.valueOf('l'), Arrays.asList("ala"))
        );

    }
}
