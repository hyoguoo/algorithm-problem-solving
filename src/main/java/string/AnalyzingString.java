/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10820
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalyzingString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String input = bufferedReader.readLine();
            if (input == null) {
                break;
            }

            stringBuilder.append(solution(input)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String input) {
        int lowerCase = 0;
        int upperCase = 0;
        int number = 0;
        int space = 0;

        for (char c : input.toCharArray()) {
            if (97 <= c && c <= 122) {
                lowerCase++;
            } else if (65 <= c && c <= 90) {
                upperCase++;
            } else if (48 <= c && c <= 57) {
                number++;
            } else if (c == 32) {
                space++;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return lowerCase + " " + upperCase + " " + number + " " + space;
    }
}
