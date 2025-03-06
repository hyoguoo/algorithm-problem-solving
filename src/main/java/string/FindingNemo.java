/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10173
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingNemo {

    private static final String END_SIGNAL = "EOI";
    private static final String TARGET_STRING = "nemo";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();

            if (END_SIGNAL.equals(input)) {
                break;
            }

            stringBuilder
                    .append(solution(input) ? "Found" : "Missing")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String input) {
        return input.toLowerCase().contains(TARGET_STRING.toLowerCase());
    }
}
