/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14246
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntervalGreaterThanK {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(numbers, k));
    }

    private static long solution(int[] numbers, long k) {
        long count = 0;
        int left = 0;
        int right = 0;
        long sum = numbers[0];

        while (left < numbers.length) {
            while (right < numbers.length && sum <= k) {
                right++;
                if (right < numbers.length) {
                    sum += numbers[right];
                }
            }

            if (right == numbers.length) {
                break;
            }

            count += numbers.length - right;

            sum -= numbers[left];
            left++;
        }

        return count;
    }
}
