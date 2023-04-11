/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20300
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeogangMuscleMan {

    public static void main(String[] args) throws IOException {
        long[] numbers = init();
        System.out.println(solution(numbers));
    }

    private static long solution(long[] numbers) {
        long maxValue = Long.MIN_VALUE;
        int length = numbers.length;

        if (length == 1) maxValue = numbers[0];
        else if (length % 2 == 0) {
            for (int i = 0; i < length / 2; i++) {
                maxValue = Math.max(maxValue, numbers[i] + numbers[length - 1 - i]);
            }
        } else {
            for (int i = 0; i < length / 2; i++) {
                maxValue = Math.max(maxValue, numbers[i] + numbers[length - 2 - i]);
            }
            maxValue = Math.max(maxValue, numbers[length - 1]);
        }

        return maxValue;
    }

    private static long[] init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        long[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(numbers);

        return numbers;
    }
}
