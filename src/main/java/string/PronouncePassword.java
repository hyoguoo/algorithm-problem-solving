/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4659
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PronouncePassword {

    static final String END = "end";
    static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    static final int VOWEL_COUNT_LIMIT = 3;
    static final int CONSONANT_COUNT_LIMIT = 3;

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

    private static String solution(String input) {
        return isAvailable(input)
                ? "<" + input + "> is acceptable."
                : "<" + input + "> is not acceptable.";
    }

    private static boolean isAvailable(String input) {
        int consonantsCount = 0;
        int vowelsCount = 0;
        boolean hasVowels = false;
        char previous = ' ';

        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                vowelsCount++;
                consonantsCount = 0;
                hasVowels = true;
            } else {
                consonantsCount++;
                vowelsCount = 0;
            }

            if (c == previous && c != 'e' && c != 'o') {
                return false;
            }

            if (consonantsCount == CONSONANT_COUNT_LIMIT || vowelsCount == VOWEL_COUNT_LIMIT) {
                return false;
            }

            previous = c;
        }

        return hasVowels;
    }

    private static boolean isVowel(char c) {
        for (char vowel : VOWELS) {
            if (c == vowel) {
                return true;
            }
        }

        return false;
    }
}
