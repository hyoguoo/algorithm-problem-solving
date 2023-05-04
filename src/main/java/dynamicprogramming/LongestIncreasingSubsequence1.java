/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11053 / 11722
 * Cheat Level: 3
 * Algorithm: Dynamic Programing / LIS
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubsequence1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = solution(numbers);

        System.out.println(getMaxValue(dp));
    }

    private static int getMaxValue(int[] dp) {
        int max = 0;
        for (int value : dp) max = Math.max(max, value);
        return max;
    }

    private static int[] solution(int[] numbers) {
        int[] dp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return dp;
    }
}
