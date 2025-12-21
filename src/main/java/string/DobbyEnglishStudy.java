/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2386
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DobbyEnglishStudy {

    private static final String END_MARKER = "#";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String inputLine = bufferedReader.readLine();

            if (inputLine.equals(END_MARKER)) {
                break;
            }
            char targetChar = Character.toLowerCase(inputLine.charAt(0));
            String sentence = inputLine.substring(2).toLowerCase();

            stringBuilder
                    .append(String.format("%c %d", targetChar, solution(targetChar, sentence)))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(char targetChar, String sentence) {
        return sentence.chars()
                .filter(c -> c == targetChar)
                .count();
    }
}
