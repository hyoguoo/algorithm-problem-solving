/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11057
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfClimbs {

    static final int MOD = 10_007;
    static final int DIGIT = 10;

    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        int[] dp = new int[DIGIT];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < DIGIT; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        return Arrays.stream(dp).sum() % MOD;
    }
}

/*
1 2 3 4
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
10
45 - 10 * 9 / 2
165
 */