package io.buell;

import org.apache.commons.cli.*;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFrequency {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption(new Option("", "input", true, "Input string."));
        CommandLineParser parser = new DefaultParser();

        String input;
        try {
            CommandLine cmd = parser.parse(options, args);
            input = cmd.getOptionValue("input", "the cat is in the bag");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        printAndOrderWordFrequency(input);
    }

    public static Map<String, Long> wordFrequency(String input) {
        if (input == null) {
            throw new NullPointerException("Input must not be null");
        }

        return Pattern.compile("\\s+").splitAsStream(input)
                .map(word -> word.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""))
                .filter(word -> !word.isEmpty() && !word.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void printAndOrderWordFrequency(String input) {
        wordFrequency(input).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
