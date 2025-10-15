/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32342
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WowAndQuery {

    private static final String WOW = "WOW";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCaseCount-- > 0) {
            String input = bufferedReader.readLine();
            stringBuilder
                    .append(solution(input))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String input) {
        int count = 0;

        for (int i = 0; i <= input.length() - WOW.length(); i++) {
            if (input.startsWith(WOW, i)) {
                count++;
            }
        }

        return count;
    }
}
