/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2953
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class IAmChef {

    private static final int PARTICIPANT_COUNT = 5;
    private static final int SCORE_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] scores = new int[PARTICIPANT_COUNT][SCORE_COUNT];

        for (int i = 0; i < PARTICIPANT_COUNT; i++) {
            int[] scoreInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            scores[i] = scoreInfo;
        }

        System.out.print(solution(scores));
    }

    private static String solution(int[][] scores) {
        int maxScore = Arrays.stream(scores)
                .mapToInt(IAmChef::getTotalScore)
                .max()
                .orElseThrow();
        return (findScoreIndex(scores, maxScore) + 1) + " " + maxScore;
    }

    private static int getTotalScore(int[] score) {
        return Arrays.stream(score)
                .sum();
    }

    private static int findScoreIndex(int[][] score, int target) {
        return IntStream.range(0, score.length)
                .filter(i -> getTotalScore(score[i]) == target)
                .findFirst()
                .orElseThrow();
    }
}
