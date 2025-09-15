/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1337
 * Cheat Level: 0
 * Algorithm: Implementation / Set
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorrectArray {

    private static final int CONTINUOUS_NUMBER_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        Set<Integer> numberSet = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(numbers)
                .map(number -> countMissingNumbers(numberSet, number))
                .min()
                .orElseThrow();
    }

    private static int countMissingNumbers(Set<Integer> numberSet, int number) {
        return IntStream.range(number, number + CONTINUOUS_NUMBER_COUNT)
                .filter(i -> !numberSet.contains(i))
                .toArray()
                .length;
    }
}
