/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2559
 * Cheat Level: 0
 * Algorithm: Prefix Sum / Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sequences {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers, k));
    }

    private static int solution(int[] numbers, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += numbers[i];
        int maximumSum = sum;

        for (int i = 0; i < numbers.length - k; i++) {
            sum = sum - numbers[i] + numbers[i + k];
            maximumSum = Math.max(maximumSum, sum);
        }

        return maximumSum;
    }
}
