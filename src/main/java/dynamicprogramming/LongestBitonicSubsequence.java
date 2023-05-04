/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11054
 * Cheat Level: 3
 * Algorithm: Dynamic Programing / LIS
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] lis = getLIS(numbers);
        int[] lds = getLIS(reverse(numbers));

        return getMax(numbers, lis, lds);
    }

    private static int getMax(int[] numbers, int[] lis, int[] lds) {
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, lis[i] + lds[numbers.length - i - 1] - 1);
        }

        return max;
    }

    private static int[] getLIS(int[] numbers) {
        int[] dp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return dp;
    }

    private static int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) reversed[i] = numbers[numbers.length - i - 1];
        return reversed;
    }
}
