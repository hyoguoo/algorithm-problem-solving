/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5218
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlphabetDistances {

    private static final int ALPHABET_COUNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String[] words = bufferedReader.readLine().split(" ");
            String word1 = words[0];
            String word2 = words[1];
            stringBuilder.append("Distances: ")
                    .append(Arrays.stream(solution(word1, word2))
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int[] solution(String word1, String word2) {
        return IntStream.range(0, word2.length())
                .map(i -> calculateDistance(word1, word2, i))
                .toArray();
    }

    private static int calculateDistance(String word1, String word2, int i) {
        int distance = word2.charAt(i) - word1.charAt(i);
        return distance < 0 ? distance + ALPHABET_COUNT : distance;
    }
}
