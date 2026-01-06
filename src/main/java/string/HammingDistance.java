/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3449
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class HammingDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            String input1 = bufferedReader.readLine();
            String input2 = bufferedReader.readLine();

            stringBuilder
                    .append("Hamming distance is ")
                    .append(solution(input1, input2))
                    .append(".")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(String input1, String input2) {
        if (input1.length() != input2.length()) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(0, input1.length())
                .filter(i -> input1.charAt(i) != input2.charAt(i))
                .count();
    }
}
