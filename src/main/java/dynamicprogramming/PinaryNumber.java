/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2193
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static long solution(int n) {
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        return dp[n][0] + dp[n][1];
    }
}
