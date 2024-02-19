/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13301
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileOrnaments {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static long solution(int n) {
        if (n == 1) return 4;
        long[] dp = calculateDp(n);

        return dp[n] * 4 + dp[n - 1] * 2;
    }

    private static long[] calculateDp(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp;
    }
}
