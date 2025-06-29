/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9076
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AggregateScores {

    private static final int NEGOTIABLE_SCORE = 4;
    private static final int KEEP_IN_NEGOTIABLE_VALUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int[] scores = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int result = solution(scores);
            stringBuilder
                    .append(result == KEEP_IN_NEGOTIABLE_VALUE
                            ? "KIN"
                            : result)
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] scores) {
        int[] validScores = Arrays.stream(scores)
                .sorted()
                .skip(1)
                .limit(scores.length - 2L)
                .toArray();

        int max = Arrays.stream(validScores).max().orElseThrow();
        int min = Arrays.stream(validScores).min().orElseThrow();
        return max - min < NEGOTIABLE_SCORE
                ? Arrays.stream(validScores).sum()
                : KEEP_IN_NEGOTIABLE_VALUE;
    }
}
