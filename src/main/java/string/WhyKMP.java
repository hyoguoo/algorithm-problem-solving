/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2902
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhyKMP {

    private static final char DASH = '-';

    public static void main(String[] args) throws IOException {
        System.out.print(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static String solution(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == DASH) {
                stringBuilder.append(input.charAt(i + 1));
            }
        }

        return stringBuilder.toString();
    }
}
