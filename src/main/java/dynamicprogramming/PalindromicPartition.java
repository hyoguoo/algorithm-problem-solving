/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2705
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromicPartition {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        int[] queries = new int[testCount];

        for (int i = 0; i < testCount; i++) {
            queries[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(queries));
    }

    private static String solution(int[] queries) {
        int max = Arrays.stream(queries).max().orElseThrow();
        int[] dp = calculateDp(max);

        return getString(queries, dp);
    }

    private static String getString(int[] queries, int[] dp) {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(queries)
                .forEach(query -> stringBuilder.append(dp[query]).append("\n"));

        return stringBuilder.toString().trim();
    }

    private static int[] calculateDp(int max) {
        int[] dp = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int diff = i - j;
                if (diff % 2 == 0) {
                    dp[i] += dp[diff / 2];
                }
            }
        }

        return dp;
    }
}
