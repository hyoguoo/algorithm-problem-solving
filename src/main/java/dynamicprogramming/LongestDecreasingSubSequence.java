/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17216
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestDecreasingSubSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] dp = new int[numbers.length];
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
