/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18870
 * Cheat Level: 0
 * Algorithm: Mathematics / Sort
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoordinateCompression {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        int[] sortedDistinctNumbers = getSortedDistinctNumbers(numbers);

        return Arrays
                .toString(mappedNumber(numbers, sortedDistinctNumbers))
                .replaceAll("[\\[\\],]", "");
    }

    private static int[] getSortedDistinctNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .distinct()
                .toArray();
    }

    private static int[] mappedNumber(int[] numbers, int[] sortedDistinctNumbers) {
        return Arrays.stream(numbers)
                .map(number -> Arrays.binarySearch(sortedDistinctNumbers, number))
                .toArray();
    }
}
