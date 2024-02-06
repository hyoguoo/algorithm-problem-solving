/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11655
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

    static final int ROTATE = 13;
    static final int LOWERCASE_START = 97;
    static final int LOWERCASE_END = 122;
    static final int UPPERCASE_START = 65;
    static final int UPPERCASE_END = 90;

    public static void main(String[] args) throws IOException {
        System.out.print(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(offset(c));
        }

        return sb.toString();
    }

    private static char offset(char c) {
        if (c >= LOWERCASE_START && c <= LOWERCASE_END) {
            return (char) ((c - LOWERCASE_START + ROTATE) % 26 + LOWERCASE_START);
        } else if (c >= UPPERCASE_START && c <= UPPERCASE_END) {
            return (char) ((c - UPPERCASE_START + ROTATE) % 26 + UPPERCASE_START);
        } else {
            return c;
        }
    }
}
