/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10211
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Brute Force
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbers) {
        int[][] prefixSums = new int[numbers.length][numbers.length];
        Arrays.stream(prefixSums).forEach(arr -> Arrays.fill(arr, Integer.MIN_VALUE));

        for (int i = 0; i < numbers.length; i++) {
            prefixSums[i][i] = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                prefixSums[i][j] = prefixSums[i][j - 1] + numbers[j];
            }
        }

        return Arrays.stream(prefixSums)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow();
    }
}
