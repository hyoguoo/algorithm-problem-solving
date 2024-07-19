/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20366
 * Cheat Level: 2
 * Algorithm: Two Pointer / Sort
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DoYouWantBuildASnowman {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                minDifference = Math.min(minDifference, findMinDifference(numbers, i, j));
            }
        }

        return minDifference;
    }

    private static int findMinDifference(int[] numbers, int i, int j) {
        int sum1 = numbers[i] + numbers[j];
        int minDifference = Integer.MAX_VALUE;

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (left == i || left == j) {
                left++;
            } else if (right == i || right == j) {
                right--;
            } else {
                int sum2 = numbers[left] + numbers[right];
                int difference = Math.abs(sum1 - sum2);
                minDifference = Math.min(minDifference, difference);

                if (sum2 < sum1) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return minDifference;
    }
}
