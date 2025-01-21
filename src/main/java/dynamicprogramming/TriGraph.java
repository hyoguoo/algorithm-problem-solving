/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4883
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TriGraph {

    private static final int COLUMN_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = 1;

        while (true) {
            int rowCount = Integer.parseInt(bufferedReader.readLine());
            if (rowCount == 0) {
                break;
            }

            int[][] graph = new int[rowCount][COLUMN_COUNT];
            for (int i = 0; i < rowCount; i++) {
                graph[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            stringBuilder
                    .append(String.format("%d. ", testCase++))
                    .append(solution(graph)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[][] graph) {
        int rowCount = graph.length;
        int[][] dp = new int[rowCount][COLUMN_COUNT];

        dp[0][0] = Integer.MAX_VALUE;
        dp[0][1] = graph[0][1];
        dp[0][2] = graph[0][1] + graph[0][2];

        for (int r = 1; r < rowCount; r++) {
            dp[r][0] = Math.min(dp[r - 1][0], dp[r - 1][1]) + graph[r][0];
            dp[r][1] = Math.min(Math.min(dp[r][0], dp[r - 1][0]), Math.min(dp[r - 1][1], dp[r - 1][2])) + graph[r][1];
            dp[r][2] = Math.min(Math.min(dp[r][1], dp[r - 1][1]), dp[r - 1][2]) + graph[r][2];
        }

        return dp[rowCount - 1][1];
    }
}
