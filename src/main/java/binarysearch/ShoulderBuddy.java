/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27932
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShoulderBuddy {

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
        int left = 0;
        int right = 1000000000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(numbers, limit, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int[] numbers, int limit, int mid) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if ((i - 1 >= 0 && Math.abs(numbers[i - 1] - numbers[i]) > mid) ||
                    (i + 1 < numbers.length && Math.abs(numbers[i + 1] - numbers[i]) > mid)) {
                count++;
            }
        }

        return count <= limit;
    }
}
