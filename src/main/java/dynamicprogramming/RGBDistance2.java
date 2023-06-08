/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17404
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGBDistance2 {

    final static int LENGTH = 3;
    final static int MAX = 1000 * 1000;
    static int N;
    static int[][] rgbList;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        int minCost = MAX;

        for (int start = 0; start < LENGTH; start++) {
            minCost = Math.min(minCost, getMinCostStartAt(start));
        }

        System.out.println(minCost);
    }

    private static int getMinCostStartAt(int start) {
        int[][] dp = new int[N][LENGTH];

        dp[0][start] = rgbList[0][start];
        dp[0][(start + 1) % LENGTH] = MAX;
        dp[0][(start + 2) % LENGTH] = MAX;

        for (int n = 1; n < N; n++) {
            dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + rgbList[n][0];
            dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + rgbList[n][1];
            dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + rgbList[n][2];
        }

        return Math.min(dp[N - 1][(start + 1) % LENGTH], dp[N - 1][(start + 2) % LENGTH]);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        rgbList = new int[N][LENGTH];

        for (int i = 0; i < N; i++) {
            int[] rgb = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rgbList[i] = rgb;
        }
    }
}
