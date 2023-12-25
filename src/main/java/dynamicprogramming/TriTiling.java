/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2133
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriTiling {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;

            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        return dp[n];
    }
}
