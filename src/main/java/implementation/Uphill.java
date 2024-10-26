/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2846
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uphill {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int maxUphill = 0;
        int currentNumber = numbers[0];
        int currentSectionMinNumber = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            int nextNumber = numbers[i];
            if (currentNumber >= nextNumber) {
                maxUphill = Math.max(maxUphill, currentNumber - currentSectionMinNumber);
                currentSectionMinNumber = nextNumber;
            }
            currentNumber = nextNumber;
        }

        maxUphill = Math.max(maxUphill, currentNumber - currentSectionMinNumber);

        return maxUphill;
    }
}
