/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1264
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOVowels {

    private static final String END = "#";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(END)) {
                break;
            }
            stringBuilder.append(solution(input)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String input) {
        return (int) input.chars()
                .filter(c -> isVowel((char) c))
                .count();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".contains(String.valueOf(c));
    }
}
