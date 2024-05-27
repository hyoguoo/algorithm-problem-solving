/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16938
 * Cheat Level: 0
 * Algorithm: Combinations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PreparingCamp {

    private static final int MINIMUM_COUNT = 2;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowerBound = info[1];
        int upperBound = info[2];
        int difference = info[3];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, lowerBound, upperBound, difference));
    }

    private static int solution(
            int[] numbers,
            int lowerBound,
            int upperBound,
            int difference
    ) {
        recursion(
                numbers,
                0,
                0,
                0,
                lowerBound,
                upperBound,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                difference
        );
        return result;
    }

    private static void recursion(
            int[] numbers,
            int index,
            int depth,
            int sum,
            int lowerBound,
            int upperBound,
            int min,
            int max,
            int difference
    ) {
        if (MINIMUM_COUNT <= depth &&
                lowerBound <= sum &&
                sum <= upperBound &&
                difference <= max - min) {
            result++;
        }

        for (int i = index; i < numbers.length; i++) {
            recursion(
                    numbers,
                    i + 1,
                    depth + 1,
                    sum + numbers[i],
                    lowerBound,
                    upperBound,
                    Math.min(min, numbers[i]),
                    Math.max(max, numbers[i]),
                    difference
            );
        }
    }
}
