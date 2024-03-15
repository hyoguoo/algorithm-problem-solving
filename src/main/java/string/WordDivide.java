/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1251
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordDivide {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        new BufferedReader(new InputStreamReader(System.in)).readLine()
                )
        );
    }

    private static String solution(String s) {
        int length = s.length();
        String result = "z".repeat(length);

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String first = new StringBuilder(s.substring(0, i)).reverse().toString();
                String second = new StringBuilder(s.substring(i, j)).reverse().toString();
                String third = new StringBuilder(s.substring(j, length)).reverse().toString();
                String temp = first + second + third;

                if (result.compareTo(temp) > 0) {
                    result = temp;
                }
            }
        }

        return result;
    }
}
