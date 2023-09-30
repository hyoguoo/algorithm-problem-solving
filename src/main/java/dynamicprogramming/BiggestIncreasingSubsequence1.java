/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11055
 * Cheat Level: 0
 * Algorithm: Dynamic Programing
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BiggestIncreasingSubsequence1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = solution(numbers);

        System.out.println(getMaxValue(dp));
    }

    private static int getMaxValue(int[] dp) {
        return Arrays.stream(dp).max().orElseThrow();
    }

    private static int[] solution(int[] numbers) {
        int[] dp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
            }
        }

        return dp;
    }
}
