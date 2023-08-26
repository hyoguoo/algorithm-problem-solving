/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1912
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContinuousSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] dp = new int[numbers.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = numbers[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(numbers[i], numbers[i] + dp[i - 1]);
        }

        return Arrays.stream(dp).max().orElse(Integer.MIN_VALUE);
    }
}
