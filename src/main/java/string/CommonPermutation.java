/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1622
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonPermutation {

    private static final int ALPHABET_COUNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String a = bufferedReader.readLine();
            if (a == null) {
                break;
            }
            String b = bufferedReader.readLine();

            stringBuilder.append(solution(a, b)).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static String solution(String a, String b) {
        return buildCommonCharacterString(countAlphabet(a), countAlphabet(b));
    }

    private static int[] countAlphabet(String string) {
        int[] aAlphabetCount = new int[ALPHABET_COUNT];
        string.chars().forEach(c -> aAlphabetCount[c - 'a']++);
        return aAlphabetCount;
    }

    private static String buildCommonCharacterString(int[] aAlphabetCount, int[] bAlphabetCount) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            int count = Math.min(aAlphabetCount[i], bAlphabetCount[i]);
            stringBuilder.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, count)));
        }

        return stringBuilder.toString();
    }
}
