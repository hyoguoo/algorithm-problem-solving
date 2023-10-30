/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1965
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / LIS
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertBox {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] dp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] >= numbers[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return Arrays.stream(dp).max().orElseThrow();
    }
}
