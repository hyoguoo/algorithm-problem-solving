/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10819
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximizeDifference {

    static int maxDifference = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(numbers);
        System.out.println(maxDifference);
    }

    private static void solution(int[] numbers) {
        Arrays.sort(numbers);
        permutation(numbers, 0);
    }

    private static void permutation(int[] numbers, int index) {
        if (index == numbers.length) {
            int difference = getDifference(numbers);
            maxDifference = Math.max(maxDifference, difference);
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            swap(numbers, index, i);
            permutation(numbers, index + 1);
            swap(numbers, index, i);
        }
    }

    private static int getDifference(int[] numbers) {
        int difference = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            difference += Math.abs(numbers[i] - numbers[i + 1]);
        }
        return difference;
    }

    private static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
