/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2670
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContinuousPartialLeastSquares {

    public static void main(String[] args) throws IOException {
        System.out.printf("%.3f", solution(parseNumbers()));
    }

    private static double[] parseNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(bufferedReader.readLine());
        double[] numbers = new double[numberCount];

        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Double.parseDouble(bufferedReader.readLine());
        }
        return numbers;
    }

    private static double solution(double[] numbers) {
        double[] dp = new double[numbers.length];

        dp[0] = numbers[0];
        double max = dp[0];

        for (int i = 1; i < numbers.length; i++) {
            dp[i] = Math.max(numbers[i], dp[i - 1] * numbers[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
