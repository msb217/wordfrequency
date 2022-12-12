package io.buell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class WordFrequencyTest {

    @Test
    public void testDefault() {
        String input = "the cat is in the bag";
        Map<String, Long> testMap = Map.of("the", 2L,
                "in", 1L,
                "cat", 1L,
                "bag", 1L,
                "is", 1L);

        Map<String, Long> wordFrequency = WordFrequency.wordFrequency(input);
        Assertions.assertEquals(wordFrequency, testMap);
    }

    @Test
    public void testEmpty() {
        String input = "";
        Map<String, Long> testMap = Map.of();

        Map<String, Long> wordFrequency = WordFrequency.wordFrequency(input);
        Assertions.assertEquals(testMap, wordFrequency);
    }

    @Test
    public void testNull() {
        String input = null;

        Assertions.assertThrows(
                NullPointerException.class,
                () -> WordFrequency.wordFrequency(input)
        );
    }

    @Test
    public void testPunctuation() {
        String input = "I'm blah the don't eat the the cat blah ugh don't blah.";
        Map<String, Long> testMap = Map.of("the", 3L, "blah", 3L,
                "dont", 2L,
                "im", 1L,
                "ugh", 1L,
                "cat", 1L,
                "eat", 1L);


        Map<String, Long> wordFrequency = WordFrequency.wordFrequency(input);
        Assertions.assertEquals(testMap, wordFrequency);
    }

    @Test
    public void testCapitalization() {
        String input = "WhY ARE you YELLING wHY why WHY";
        Map<String, Long> testMap = Map.of("why", 4L,
                "are", 1L,
                "yelling", 1L,
                "you", 1L);

        Map<String, Long> wordFrequency = WordFrequency.wordFrequency(input);
        Assertions.assertEquals(testMap, wordFrequency);
    }
}
