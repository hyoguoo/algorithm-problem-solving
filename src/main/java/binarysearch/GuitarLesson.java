/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2343
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GuitarLesson {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetDivideCount = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, targetDivideCount));
    }

    private static int solution(int[] numbers, int targetDivideCount) {
        int left = Arrays.stream(numbers).max().orElseThrow();
        int right = Arrays.stream(numbers).sum();

        while (left < right) {
            int mid = (left + right) / 2;
            int count = determineLessonCount(numbers, mid);

            if (count <= targetDivideCount) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int determineLessonCount(int[] numbers, int mid) {
        int count = 1;
        int sum = 0;

        for (int number : numbers) {
            if (sum + number > mid) {
                count++;
                sum = 0;
            }
            sum += number;
        }

        return count;
    }
}
