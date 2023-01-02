/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2579
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] stairs = new int[length + 1];
        for (int i = 1; i <= length; i++) stairs[i] = Integer.parseInt(bufferedReader.readLine());

        if (length == 1) System.out.println(stairs[length]);
        else System.out.println(getMaxScore(stairs));
    }

    private static int getMaxScore(int[] stairs) {
        int[] dp = new int[stairs.length];
        dp[0] = stairs[0];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i < stairs.length; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        return dp[dp.length - 1];
    }
}
