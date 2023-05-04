/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17175
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciIsBoring {

    final static int MOD = 1000000007;
    final static int LIMIT = 50;

    public static void main(String[] args) throws IOException {
        int N = init();

        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int[] dp = new int[LIMIT + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= LIMIT; i++) dp[i] = (dp[i - 1] + dp[i - 2] + 1) % MOD;

        return dp[N];
    }

    private static int init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }
}
