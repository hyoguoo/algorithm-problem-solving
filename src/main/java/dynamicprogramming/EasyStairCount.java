/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10844
 * Cheat Level: 3
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairCount {

    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int n) {
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            dp[i][9] = dp[i - 1][8];
        }

        int sum = 0;

        for (int i = 0; i <= 9; i++) sum = (sum + dp[n][i]) % MOD;

        return sum;
    }
}
