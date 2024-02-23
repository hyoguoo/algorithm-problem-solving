/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1253
 * Cheat Level: 2
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Good {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(solution(numbers));
    }

    private static int solution(long[] numbers) {
        Arrays.sort(numbers);
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (findSumPair(numbers, i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean findSumPair(long[] numbers, int i) {
        long target = numbers[i];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (left == i || right == i) {
                if (left == i) {
                    left++;
                } else {
                    right--;
                }
                continue;
            }

            long sum = numbers[left] + numbers[right];

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
