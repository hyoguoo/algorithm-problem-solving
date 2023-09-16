/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1904
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile01 {

    final static int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int N) {
        int[] dp = new int[N + 1];

        dp[1] = 1;
        if (N >= 2) dp[2] = 2;

        for (int n = 3; n <= N; n++) {
            dp[n] = (dp[n - 1] + dp[n - 2]) % MOD;
        }

        return dp[N];
    }
}
