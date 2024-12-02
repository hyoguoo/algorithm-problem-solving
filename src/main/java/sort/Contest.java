/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5576
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Contest {

    private static final int W_SCORE_COUNT = 10;
    private static final int K_SCORE_COUNT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] wScores = new int[W_SCORE_COUNT];
        int[] kScores = new int[K_SCORE_COUNT];

        for (int i = 0; i < W_SCORE_COUNT; i++) {
            wScores[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < K_SCORE_COUNT; i++) {
            kScores[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(wScores, kScores));
    }

    private static String solution(int[] wScores, int[] kScores) {
        return getTopThreeScores(wScores) + " " + getTopThreeScores(kScores);
    }

    private static int getTopThreeScores(int[] scores) {
        return IntStream.of(scores)
                .sorted()
                .skip(scores.length - 3L)
                .sum();
    }
}
