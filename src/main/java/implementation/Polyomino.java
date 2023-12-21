/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1343
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polyomino {

    static final String FOUR_TIMES_X = "XXXX";
    static final String TWO_TIMES_X = "XX";
    static final String DOT = ".";
    static final String POLYOMINO_A = "AAAA";
    static final String POLYOMINO_B = "BB";

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        while (!s.isEmpty()) {
            if (s.startsWith(FOUR_TIMES_X)) {
                stringBuilder.append(POLYOMINO_A);
                s = s.substring(FOUR_TIMES_X.length());
            } else if (s.startsWith(TWO_TIMES_X)) {
                stringBuilder.append(POLYOMINO_B);
                s = s.substring(TWO_TIMES_X.length());
            } else if (s.startsWith(DOT)) {
                stringBuilder.append(DOT);
                s = s.substring(DOT.length());
            } else {
                return "-1";
            }
        }

        return stringBuilder.toString();
    }
}
