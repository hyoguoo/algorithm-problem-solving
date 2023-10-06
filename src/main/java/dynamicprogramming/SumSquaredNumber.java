/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1699
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Mathematics
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumSquaredNumber {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int number) {
        int[] dp = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[number];
    }
}
