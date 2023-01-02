/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11726
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2xN {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[1000 + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= target; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        System.out.println(dp[target]);
    }
}