/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27649
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tokenizer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    public static String solution(String command) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentToken = new StringBuilder();

        int index = 0;
        while (index < command.length()) {
            char c = command.charAt(index);
            if (c == '<' || c == '>' || c == '(' || c == ')') {
                appendToken(currentToken, result);
                result.append(c).append(" ");
            } else if ((c == '&' || c == '|') &&
                    index + 1 < command.length() &&
                    command.charAt(index + 1) == c) {
                appendToken(currentToken, result);
                result.append(c).append(c).append(" ");
                index++;
            } else if (c == ' ') {
                appendToken(currentToken, result);
            } else {
                currentToken.append(c);
            }

            index++;
        }

        if (currentToken.length() > 0) {
            result.append(currentToken.toString().trim());
        }

        return result.toString();
    }

    private static void appendToken(StringBuilder currentToken, StringBuilder result) {
        if (currentToken.length() > 0) {
            result.append(currentToken.toString().trim()).append(" ");
            currentToken.delete(0, currentToken.length());
        }
    }
}
