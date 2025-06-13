/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1148
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateWord {

    private static final String WORD_END_COMMAND = "-";
    private static final String PUZZLE_END_COMMAND = "#";
    private static final int ALPHABET_COUNT = 26;
    private static final char START_CHAR = 'A';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> wordList = new ArrayList<>();
        List<String> puzzleList = new ArrayList<>();

        while (true) {
            String word = bufferedReader.readLine();
            if (WORD_END_COMMAND.equals(word)) {
                break;
            }
            wordList.add(word);
        }

        while (true) {
            String puzzle = bufferedReader.readLine();
            if (PUZZLE_END_COMMAND.equals(puzzle)) {
                break;
            }
            puzzleList.add(puzzle);
        }

        System.out.print(
                solution(wordList, puzzleList).stream()
                        .map(Result::toString)
                        .collect(Collectors.joining("\n"))
        );
    }

    private static List<Result> solution(List<String> wordList, List<String> puzzleList) {
        List<WordInfo> wordInfos = wordList.stream()
                .map(WordInfo::new)
                .collect(Collectors.toList());

        List<Result> resultList = new ArrayList<>();

        for (String puzzle : puzzleList) {
            int[] puzzleFreq = buildFrequencyArray(puzzle);
            int[] letterCounts = new int[ALPHABET_COUNT];

            for (WordInfo wordInfo : wordInfos) {
                if (!isWordUsable(wordInfo.freq, puzzleFreq)) {
                    continue;
                }

                countMatchingLetters(letterCounts, wordInfo.letters);
            }

            resultList.add(buildResult(puzzleFreq, letterCounts));
        }

        return resultList;
    }

    private static int[] buildFrequencyArray(String str) {
        int[] freq = new int[ALPHABET_COUNT];

        for (char c : str.toCharArray()) {
            freq[c - START_CHAR]++;
        }

        return freq;
    }

    private static boolean isWordUsable(int[] wordFreq, int[] puzzleFreq) {
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (wordFreq[i] > puzzleFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private static void countMatchingLetters(int[] counts, char[] letters) {
        boolean[] used = new boolean[ALPHABET_COUNT];
        for (char c : letters) {
            int idx = c - START_CHAR;

            if (!used[idx]) {
                counts[idx]++;
                used[idx] = true;
            }
        }
    }

    private static Result buildResult(int[] puzzleFreq, int[] counts) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        List<Character> maxChars = new ArrayList<>();
        List<Character> minChars = new ArrayList<>();

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (puzzleFreq[i] == 0) {
                continue;
            }

            if (counts[i] > max) {
                max = counts[i];
                maxChars.clear();
                maxChars.add((char) (i + START_CHAR));
            } else if (counts[i] == max) {
                maxChars.add((char) (i + START_CHAR));
            }

            if (counts[i] < min) {
                min = counts[i];
                minChars.clear();
                minChars.add((char) (i + START_CHAR));
            } else if (counts[i] == min) {
                minChars.add((char) (i + START_CHAR));
            }
        }

        return new Result(minChars, min, maxChars, max);
    }

    static class Result {

        private final List<Character> minimumWordList;
        private final int minimumCount;
        private final List<Character> maximumWordList;
        private final int maximumCount;

        public Result(List<Character> minimumWordList,
                int minimumCount,
                List<Character> maximumWordList,
                int maximumCount) {
            this.minimumWordList = minimumWordList.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            this.minimumCount = minimumCount;
            this.maximumWordList = maximumWordList.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            this.maximumCount = maximumCount;
        }

        @Override
        public String toString() {
            return minimumWordList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()) + " " +
                    minimumCount + " " +
                    maximumWordList.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining()) + " " +
                    maximumCount;
        }
    }

    static class WordInfo {

        final int[] freq = new int[ALPHABET_COUNT];
        final char[] letters;
        final String word;

        public WordInfo(String word) {
            this.word = word;
            this.letters = word.toCharArray();
            for (char c : letters) {
                freq[c - START_CHAR]++;
            }
        }
    }
}
