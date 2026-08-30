package string.Week2.assignment_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class StopWordFilteredWordFrequency {

    void printFilteredWordFrequency(String feedback) {

        // Stop words
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split the sentence into words
        String[] words = feedback.split("\\s+");

        // Store word and frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            // Ignore stop words
            if (stopWords.contains(word)) {
                continue;
            }

            // Count the word
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Print words sorted by frequency (descending)
        frequency.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " : " + entry.getValue()
                        ));
    }

    public static void main(String[] args) {

        StopWordFilteredWordFrequency obj =
                new StopWordFilteredWordFrequency();

        obj.printFilteredWordFrequency(
                "The service was excellent, and the service was fast. "
                + "The staff was excellent."
        );
    }
}