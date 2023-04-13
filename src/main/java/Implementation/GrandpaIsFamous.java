/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5766
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GrandpaIsFamous {

    final static int MAX_PLAYER_NUMBER = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = info[0];
            int m = info[1];
            if (n == 0 && m == 0) break;
            int[][] scores = new int[n][m];
            for (int i = 0; i < n; i++) {
                scores[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println(solution(scores));
        }
    }

    private static String solution(int[][] scores) {
        int[] playerScore = getPlayerScore(scores);
        int secondHighestScore = getSecondHighestScore(playerScore);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < playerScore.length; i++) {
            if (playerScore[i] == secondHighestScore) {
                stringBuilder.append(i).append(" ");
            }
        }

        return stringBuilder.toString();
    }

    private static int[] getPlayerScore(int[][] scores) {
        int[] playerScore = new int[MAX_PLAYER_NUMBER + 1];

        for (int[] score : scores) {
            for (int player : score) {
                playerScore[player]++;
            }
        }
        return playerScore;
    }

    private static int getSecondHighestScore(int[] playerScore) {
        int highestScore = Integer.MIN_VALUE;
        int secondHighestScore = Integer.MIN_VALUE;
        for (int score : playerScore) {
            if (score > highestScore) {
                secondHighestScore = highestScore;
                highestScore = score;
            } else if (score > secondHighestScore && score != highestScore) {
                secondHighestScore = score;
            }
        }
        return secondHighestScore;
    }
}
