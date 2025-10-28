/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2495
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContinuousSection {

    private static final int TEST_CASE_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        for (int t = 0; t < TEST_CASE_COUNT; t++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder
                    .append(solution(numbers))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbers) {
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 1;
            }
        }

        return maxCount;
    }
}
