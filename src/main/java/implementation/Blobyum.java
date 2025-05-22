/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24499
 * Cheat Level: 0
 * Algorithm: Sliding Window
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Blobyum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int limit = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, limit));
    }

    private static int solution(int[] numbers, int limit) {
        int startIndex = 0;
        int endIndex = limit - 1;
        int currentSum = Arrays.stream(numbers)
                .limit(limit)
                .sum();
        int maxSum = currentSum;

        for (int i = 0; i < numbers.length; i++) {
            endIndex = (endIndex + 1) % numbers.length;
            currentSum = currentSum - numbers[startIndex] + numbers[endIndex];
            startIndex = (startIndex + 1) % numbers.length;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
