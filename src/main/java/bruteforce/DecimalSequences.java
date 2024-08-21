/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11747
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DecimalSequences {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int number : numbers) {
                stringBuilder.append(number);
            }
        }

        System.out.print(solution(stringBuilder.toString()));
    }

    private static int solution(String concatenateNumberString) {
        int smallestMissingNumber = 0;

        while (true) {
            if (!concatenateNumberString.contains(String.valueOf(smallestMissingNumber))) {
                return smallestMissingNumber;
            }
            smallestMissingNumber++;
        }
    }
}
