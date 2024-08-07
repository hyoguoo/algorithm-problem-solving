/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3613
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaVsCpp {

    static final String BIG_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final char UNDERSCORE = '_';
    static final String ERROR_MESSAGE = "Error!";

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        new BufferedReader(new InputStreamReader(System.in)).readLine()
                )
        );
    }

    private static String solution(String s) {
        if (isUnavailableConvention(s)) {
            return ERROR_MESSAGE;
        } else if (s.contains(String.valueOf(UNDERSCORE))) {
            return convertToJava(s);
        } else {
            return convertToCpp(s);
        }
    }

    private static String convertToJava(String cppString) {
        StringBuilder stringBuilder = new StringBuilder();

        boolean isBigLetter = false;

        for (char c : cppString.toCharArray()) {
            if (c == UNDERSCORE) {
                isBigLetter = true;
            } else if (isBigLetter) {
                stringBuilder.append(Character.toUpperCase(c));
                isBigLetter = false;
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    private static String convertToCpp(String javaString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : javaString.toCharArray()) {
            if (BIG_LETTERS.contains(String.valueOf(c))) {
                stringBuilder.append(UNDERSCORE);
                stringBuilder.append(Character.toLowerCase(c));
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isUnavailableConvention(String s) {
        return (s.contains(String.valueOf(UNDERSCORE)) && containsBigLetters(s)) ||
                s.startsWith(String.valueOf(UNDERSCORE)) ||
                s.endsWith(String.valueOf(UNDERSCORE)) ||
                s.contains("" + UNDERSCORE + UNDERSCORE) ||
                BIG_LETTERS.contains(String.valueOf(s.charAt(0)));
    }

    private static boolean containsBigLetters(String s) {
        for (char c : BIG_LETTERS.toCharArray()) {
            if (s.contains(String.valueOf(c))) {
                return true;
            }
        }

        return false;
    }
}
