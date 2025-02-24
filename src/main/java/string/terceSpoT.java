/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11365
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class terceSpoT {

    private static final String END_SIGNAL = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(END_SIGNAL)) {
                break;
            }
            stringBuilder.append(solution(input)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
