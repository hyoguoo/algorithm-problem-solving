/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11497
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LogJumping {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbers) {
        return calculateMaxDifference(
                numbers,
                getZigzagSort(numbers)
        );
    }

    private static int[] getZigzagSort(int[] numbers) {
        Arrays.sort(numbers);
        int[] result = new int[numbers.length];

        int left = 0;
        int right = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                result[left++] = numbers[i];
            } else {
                result[right--] = numbers[i];
            }
        }

        return result;
    }

    private static int calculateMaxDifference(int[] numbers, int[] result) {
        int max = Math.abs(result[0] - result[numbers.length - 1]);

        for (int i = 0; i < numbers.length - 1; i++) {
            max = Math.max(max, Math.abs(result[i] - result[i + 1]));
        }

        return max;
    }
}
