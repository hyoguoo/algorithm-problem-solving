/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24051
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgorithmLessonInsertionSort1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int insertSequence = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(insertSequence, numbers));
    }

    private static int solution(int insertSequence, int[] numbers) {
        int count = 0;

        for (int i = 1; i < numbers.length; i++) {
            int insertValue = numbers[i];
            int insertIndex = findInsertIndex(numbers, i);

            for (int j = i; j > insertIndex; j--) {
                numbers[j] = numbers[j - 1];
                count++;
                if (count == insertSequence) {
                    return numbers[j];
                }
            }

            numbers[insertIndex] = insertValue;
            if (insertIndex != i) {
                count++;
                if (count == insertSequence) {
                    return insertValue;
                }
            }
        }
        return -1;
    }

    private static int findInsertIndex(int[] numbers, int currentIndex) {
        int targetValue = numbers[currentIndex];

        for (int j = currentIndex - 1; j >= 0; j--) {
            if (numbers[j] < targetValue) {
                return j + 1;
            }
            if (j == 0) {
                return 0;
            }
        }
        return currentIndex;
    }
}
