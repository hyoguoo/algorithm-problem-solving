/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1371
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MostCharacters {

    private static final int ALPHABET_COUNT = 26;
    private static final char FIRST_ALPHABET = 'a';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = new ArrayList<>();

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            lines.add(line);
        }

        System.out.print(solution(lines));
    }

    private static String solution(List<String> lines) {
        int[] alphabetFrequency = new int[ALPHABET_COUNT];

        lines.forEach(
                line -> line.chars()
                        .filter(c -> c != ' ')
                        .forEach(c -> alphabetFrequency[c - FIRST_ALPHABET]++)
        );

        int maxFrequency = Arrays.stream(alphabetFrequency).max().orElseThrow();

        return IntStream.range(0, ALPHABET_COUNT)
                .filter(i -> alphabetFrequency[i] == maxFrequency)
                .mapToObj(i -> String.valueOf((char) (i + FIRST_ALPHABET)))
                .collect(Collectors.joining());
    }
}
