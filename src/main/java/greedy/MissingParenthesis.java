/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1541
 * Cheat Level: 0
 * Algorithm: Greedy / Mathematics
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingParenthesis {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.print(solution(input));
    }

    private static int solution(String input) {
        String[] subtraction = input.split("-");
        int result = sum(subtraction[0]);

        for (int i = 1; i < subtraction.length; i++) {
            result -= sum(subtraction[i]);
        }

        return result;
    }

    private static int sum(String input) {
        return Arrays.stream(input.split("\\+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
