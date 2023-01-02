/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5598
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarCipher {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(input, 3));
    }

    public static String solution(String input, int offset) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            output.append(offsetChar(letter, offset));
        }
        return output.toString();
    }

    public static char offsetChar(char letter, int offset) {
        int correction = (int) letter - offset < 65 ? 26 : 0;
        return (char) ((int) letter - offset + correction);
    }
}
