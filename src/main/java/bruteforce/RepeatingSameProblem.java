/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22970
 * Cheat Level: 0
 * Algorithm: Implementation / Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepeatingSameProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] increasingRun = buildIncreasingRun(numbers);
        int[] decreasingRun = buildDecreasingRun(numbers);

        int maxLength = 1;

        for (int i = 0; i < numbers.length; i++) {
            if (increasingRun[i] + 1 > maxLength) {
                maxLength = increasingRun[i] + 1;
            }
            if (decreasingRun[i] + 1 > maxLength) {
                maxLength = decreasingRun[i] + 1;
            }
            if (increasingRun[i] > 0 && decreasingRun[i] > 0) {
                int bitonicLength = increasingRun[i] + decreasingRun[i] + 1;
                if (bitonicLength > maxLength) {
                    maxLength = bitonicLength;
                }
            }
        }

        return maxLength;
    }

    private static int[] buildIncreasingRun(int[] numbers) {
        int length = numbers.length;
        int[] increasingRun = new int[length];

        for (int idx = 1; idx < length; idx++) {
            if (numbers[idx - 1] < numbers[idx]) {
                increasingRun[idx] = increasingRun[idx - 1] + 1;
            } else {
                increasingRun[idx] = 0;
            }
        }

        return increasingRun;
    }

    private static int[] buildDecreasingRun(int[] numbers) {
        int length = numbers.length;
        int[] decreasingRun = new int[length];

        for (int idx = length - 2; idx >= 0; idx--) {
            if (numbers[idx] > numbers[idx + 1]) {
                decreasingRun[idx] = decreasingRun[idx + 1] + 1;
            } else {
                decreasingRun[idx] = 0;
            }
        }

        return decreasingRun;
    }
}
