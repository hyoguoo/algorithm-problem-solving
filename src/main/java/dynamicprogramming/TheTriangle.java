/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1932
 * Cheat Level: 0
 * Algorithm: Dynamic Programing
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheTriangle {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(length));
    }

    private static int solution(int length) throws IOException {
        int[] dp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 2; i <= length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < i; j++) {
                if (j == 0) numbers[j] += dp[j];
                else if (j == i - 1) numbers[j] += dp[j - 1];
                else numbers[j] += Math.max(dp[j - 1], dp[j]);
            }

            dp = numbers;
        }

        return getMaxValue(dp);
    }

    private static int getMaxValue(int[] dp) {
        return Arrays.stream(dp).max().orElseThrow();
    }
}
