/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10987
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfVowels {

    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.print(solution(input));
    }

    private static long solution(String input) {
        return input.chars()
                .filter(c -> isVowel((char) c))
                .count();
    }

    private static boolean isVowel(char c) {
        return new String(VOWELS).contains(String.valueOf(c));
    }
}
