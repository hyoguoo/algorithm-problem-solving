/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2156
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wineCount = Integer.parseInt(bufferedReader.readLine());
        int[] wines = new int[wineCount];
        for (int i = 0; i < wineCount; i++) {
            wines[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(wines));
    }

    private static int solution(int[] wines) {
        int[][] dp = new int[wines.length + 1][3];

        for (int i = 0; i < wines.length; i++) {
            int wine = wines[i];
            dp[i + 1][0] = Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2]));
            dp[i + 1][1] = dp[i][0] + wine;
            dp[i + 1][2] = dp[i][1] + wine;
        }

        return Math.max(dp[wines.length][0], Math.max(dp[wines.length][1], dp[wines.length][2]));
    }
}
