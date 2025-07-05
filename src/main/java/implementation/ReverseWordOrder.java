/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12605
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseWordOrder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int t = 1; t <= testCaseCount; t++) {
            String result = solution(bufferedReader.readLine());
            stringBuilder.append(String.format("Case #%d: %s", t, result))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String s) {
        return Arrays.stream(s.split(" "))
                .map(String::trim)
                .reduce((first, second) -> second + " " + first)
                .orElseThrow();
    }
}
