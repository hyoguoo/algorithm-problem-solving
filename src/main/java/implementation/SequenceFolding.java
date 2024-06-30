/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9358
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceFolding {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCount; i++) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append("Case #")
                    .append(i)
                    .append(": ")
                    .append(solution(numbers) ? "Alice" : "Bob")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int[] numbers) {
        int length = numbers.length;

        while (length > 2) {
            int newLength = (length + 1) / 2;
            for (int i = 0; i < newLength; i++) {
                numbers[i] = numbers[i] + numbers[length - 1 - i];
            }
            length = newLength;
        }

        return numbers[0] > numbers[1];
    }
}
