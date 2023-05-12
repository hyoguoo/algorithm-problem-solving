/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1806
 * Cheat Level: 2
 * Algorithm: Two Pointer / Prefix Sum
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Subsequence {

    static long MINIMUM_SUM;
    static long[] numbers;
    static int minimumLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        findMinimumLength();
        System.out.println(minimumLength == Integer.MAX_VALUE ? 0 : minimumLength);
    }

    private static void findMinimumLength() {
        if (numbers[0] >= MINIMUM_SUM) {
            minimumLength = 1;
            return;
        }

        int left = 0;
        int right = 1;
        long sum = numbers[left] + numbers[right];

        while (true) {
            if (sum >= MINIMUM_SUM) {
                int length = right - left + 1;
                minimumLength = Math.min(minimumLength, length);
            }

            if (sum < MINIMUM_SUM) {
                right++;
                if (right == numbers.length) break;
                sum += numbers[right];
            } else {
                sum -= numbers[left];
                left++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        MINIMUM_SUM = info[1];
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}
