/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9095
 * Cheat Level: 3
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Adding1s2sAnd3s4 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        int max = Arrays.stream(numbers).max().orElse(0);

        int[][] dp = calculateDp(max);

        return resultToString(numbers, dp);
    }

    private static int[][] calculateDp(int max) {
        int[][] dp = new int[max + 1][3 + 1];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        return dp;
    }

    private static String resultToString(int[] numbers, int[][] dp) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int number : numbers) {
            int sum = 0;
            for (int n : dp[number]) {
                sum += n;
            }
            stringBuilder.append(sum).append("\n");
        }

        return stringBuilder.toString();
    }
}
