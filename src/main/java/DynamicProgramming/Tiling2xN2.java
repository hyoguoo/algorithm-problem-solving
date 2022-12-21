/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11727
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2xN2 {

    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= target; i++) dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        System.out.println(dp[target]);
    }
}
