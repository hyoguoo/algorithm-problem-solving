/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10972
 * Cheat Level: 3
 * Algorithm: Permutations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        int[] result = findNextPermutation(numbers);

        return result.length == 0 ? "-1" :
                Arrays.stream(result)
                        .mapToObj(String::valueOf)
                        .reduce((a, b) -> a + " " + b)
                        .orElseThrow();
    }

    private static int[] findNextPermutation(int[] numbers) {
        int i = findFirstDecreasingIndex(numbers);

        if (i == -1) {
            return new int[0];
        }

        return swapAndReverse(numbers, i);
    }

    private static int[] swapAndReverse(int[] numbers, int i) {
        int j = findFirstLargerIndex(numbers, i);

        swap(numbers, i, j);

        reverse(numbers, i + 1);

        return numbers;
    }

    private static int findFirstLargerIndex(int[] numbers, int i) {
        for (int j = numbers.length - 1; j > i; j--) {
            if (numbers[j] > numbers[i]) {
                return j;
            }
        }
        return -1;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void reverse(int[] numbers, int i) {
        int j = numbers.length - 1;
        while (i < j) {
            swap(numbers, i++, j--);
        }
    }

    private static int findFirstDecreasingIndex(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] < numbers[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
