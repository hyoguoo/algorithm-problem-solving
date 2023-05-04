/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1932
 * Cheat Level: 2
 * Algorithm: Dynamic Programing
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        int[] dp = solution(length, bufferedReader);
        System.out.println(getMaxValue(dp));
    }

    private static int getMaxValue(int[] dp) {
        int max = 0;
        for (int value : dp) max = Math.max(max, value);
        return max;
    }

    private static int[] solution(int length, BufferedReader bufferedReader) throws IOException {
        int[] dp = new int[length];
        dp[0] = Integer.parseInt(bufferedReader.readLine());

        for (int i = 2; i <= length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < i; j++) {
               if (j == 0) numbers[j] += dp[j];
               else if (j == i - 1) numbers[j] += dp[j - 1];
               else numbers[j] += Math.max(dp[j - 1], dp[j]);
            }
            dp = numbers;
        }
        return dp;
    }
}
