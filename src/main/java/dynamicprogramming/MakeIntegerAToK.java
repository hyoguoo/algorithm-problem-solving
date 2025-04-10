/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25418
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeIntegerAToK {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers[0], numbers[1]));
    }

    private static int solution(int a, int k) {
        if (a == k) {
            return 0;
        }

        int[] dp = Arrays.stream(new int[k + 1])
                .map(i -> Integer.MAX_VALUE)
                .toArray();
        dp[a] = 0;

        for (int i = a; i <= k; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (i + 1 <= k) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i * 2 <= k) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
        }

        return dp[k];
    }
}
