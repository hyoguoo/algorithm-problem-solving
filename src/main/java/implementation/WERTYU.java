/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4378
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WERTYU {

    private static final char[][] KEYBOARD = {
            {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
            {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'},
            {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''},
            {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'}
    };

    private static final char SPACE = ' ';

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
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == SPACE) {
                stringBuilder.append(SPACE);
                continue;
            }

            for (int i = 0; i < KEYBOARD.length; i++) {
                for (int j = 0; j < KEYBOARD[i].length; j++) {
                    if (KEYBOARD[i][j] == c) {
                        stringBuilder.append(KEYBOARD[i][j - 1]);
                        break;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
