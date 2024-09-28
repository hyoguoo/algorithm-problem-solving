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
        int[] sortedNumbers = getSortedNumbers(numbers);
        int[] compressedNumbers = getCompressedNumbers(sortedNumbers);

        return Arrays
                .toString(mappedNumber(numbers, compressedNumbers))
                .replaceAll("[\\[\\],]", "");
    }

    private static int[] getSortedNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .toArray();
    }

    private static int[] getCompressedNumbers(int[] sortedNumbers) {
        return Arrays.stream(sortedNumbers)
                .distinct()
                .sorted()
                .toArray();
    }

    private static int[] mappedNumber(int[] numbers, int[] compressedNumbers) {
        return Arrays.stream(numbers)
                .map(number -> Arrays.binarySearch(compressedNumbers, number))
                .toArray();
    }
}
