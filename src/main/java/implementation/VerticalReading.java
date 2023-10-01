/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10798
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerticalReading {

    static final int MAX_LENGTH = 15;
    static final int LINE_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[LINE_COUNT][MAX_LENGTH];
        for (int i = 0; i < LINE_COUNT; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            System.arraycopy(line, 0, input[i], 0, line.length);
        }

        System.out.println(solution(input));
    }

    private static String solution(char[][] input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < LINE_COUNT; j++) {
                char c = input[j][i];
                if (c != '\u0000') stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
