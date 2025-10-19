/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10769
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HappyOrSad {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static Mood solution(String input) {
        int patternLength = Emotion.HAPPY.toString().length();

        long happyCount = IntStream.range(0, input.length() - patternLength + 1)
                .mapToObj(i -> input.substring(i, i + patternLength))
                .filter(s -> s.equals(Emotion.HAPPY.toString()))
                .count();

        long sadCount = IntStream.range(0, input.length() - patternLength + 1)
                .mapToObj(i -> input.substring(i, i + patternLength))
                .filter(s -> s.equals(Emotion.SAD.toString()))
                .count();

        if (happyCount == 0 && sadCount == 0) {
            return Mood.NONE;
        }
        if (happyCount == sadCount) {
            return Mood.UNSURE;
        }

        return Stream.of(
                        new SimpleEntry<>(Mood.HAPPY, happyCount),
                        new SimpleEntry<>(Mood.SAD, sadCount)
                )
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Mood.NONE);
    }

    enum Emotion {
        HAPPY(":-)"),
        SAD(":-(");

        private final String symbol;

        Emotion(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }

    enum Mood {
        HAPPY("happy"),
        SAD("sad"),
        NONE("none"),
        UNSURE("unsure");

        private final String description;

        Mood(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }
}
