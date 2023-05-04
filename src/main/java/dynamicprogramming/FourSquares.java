/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17626
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        int[] dp = solution(target);
        System.out.println(dp[target]);
    }

    private static int[] solution(int target) {
        final int[] dp = new int[50000 + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= target; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                if (j * j > i) break;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp;
    }
}
