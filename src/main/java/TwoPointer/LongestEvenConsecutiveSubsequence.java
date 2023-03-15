/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22862 / 22857
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestEvenConsecutiveSubsequence {

    static int ODD_COUNT_LIMIT;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ODD_COUNT_LIMIT = info[1];
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution());
    }

    private static int solution() {
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        int max = 0;
        int oddCount = 0;

        while (endIndex < numbers.length) {
            if (isEven(numbers[endIndex])) {
                count++;
            } else {
                oddCount++;
                while (oddCount > ODD_COUNT_LIMIT) {
                    if (!isEven(numbers[startIndex])) oddCount--;
                    else count--;
                    startIndex++;
                }
            }
            max = Math.max(max, count);
            endIndex++;
        }

        return max;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
