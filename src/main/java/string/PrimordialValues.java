/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9214
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimordialValues {

    private static final String END = "0";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = 1;

        while (true) {
            String s = bufferedReader.readLine();
            if (s.equals(END)) {
                break;
            }
            stringBuilder
                    .append("Test ")
                    .append(testCase)
                    .append(": ")
                    .append(solution(s))
                    .append("\n");
            testCase++;
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String s) {
        String previous = s;

        while (true) {
            if (previous.length() % 2 == 1) {
                return previous;
            }
            String string = calculatePrimordialValues(previous);
            if (string.equals(previous)) {
                return string;
            }
            previous = string;
        }
    }

    private static String calculatePrimordialValues(String previous) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < previous.length(); i += 2) {
            int repeatCount = Integer.parseInt(String.valueOf(previous.charAt(i)));
            char c = previous.charAt(i + 1);
            stringBuilder.append(String.valueOf(c).repeat(Math.max(0, repeatCount)));
        }

        return stringBuilder.toString();
    }
}
