package com.tdlugozima.util;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class StringMapperTest {
    @Test
    public void extractValidWordsOnly_emptyString_shouldReturnEmptySet() throws Exception {
        assertEquals(Collections.emptySet(), StringMapper.extractValidWordsOnly(""));
    }

    @Test
    public void extractValidWordsOnly_nonAlphanumericString_shouldReturnOnlyValidWords() throws Exception {
        Set<String> results = StringMapper.extractValidWordsOnly("$ ala #-kota ma");
        assertThat(results).containsExactlyInAnyOrder("kota", "ma", "ala");
    }

    @Test
    public void extractValidWordsOnly_RandomCaseString_shouldReturnOnlyOneWordOccurance() throws Exception {
        Set<String> results = StringMapper.extractValidWordsOnly("Ala ala ala ma");
        assertThat(results).containsExactlyInAnyOrder("ma", "ala");
    }

    @Test
    public void extractValidWordsOnly_WhiteCharactersString_shouldReturnOnlyValidWords() throws Exception {
        Set<String> results = StringMapper.extractValidWordsOnly("$$ > \t   ala \t");
        assertThat(results).containsExactlyInAnyOrder("ala");
    }
}