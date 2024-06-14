/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30804
 * Cheat Level: 0
 * Algorithm: Implementation / Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FruitTanghulu {

    private static final int NUMBER_LIMIT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int maxLength = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int[] numberCount = new int[NUMBER_LIMIT + 1];
        int kindCount = 0;

        numberCount[numbers[rightIndex]]++;
        kindCount++;

        while (leftIndex <= rightIndex) {
            if (kindCount <= 2) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
                rightIndex++;
                if (rightIndex >= numbers.length) {
                    break;
                }
                if (numberCount[numbers[rightIndex]] == 0) {
                    kindCount++;
                }
                numberCount[numbers[rightIndex]]++;
            } else {
                numberCount[numbers[leftIndex]]--;
                if (numberCount[numbers[leftIndex]] == 0) {
                    kindCount--;
                }
                leftIndex++;
            }
        }

        return maxLength;
    }
}
