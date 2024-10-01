/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10610
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Number30 {

    private static final String IMPOSSIBLE = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        if (!input.contains("0") || addAllDigits(input) % 3 != 0) {
            return IMPOSSIBLE;
        }

        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        return reverseString(chars);
    }

    private static String reverseString(char[] chars) {
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    private static int addAllDigits(String input) {
        return input
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
