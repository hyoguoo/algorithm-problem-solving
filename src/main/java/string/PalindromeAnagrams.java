/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30458
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeAnagrams {

    private static final int ALPHABET_COUNT = 26;
    private static final char ALPHABET_START = 'a';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        System.out.print(solution(bufferedReader.readLine()) ? "Yes" : "No");
    }

    private static boolean solution(String s) {
        int[] alphabetCount = countAlphabet(s);

        int oddCount = 0;

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (alphabetCount[i] % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount == 0;
    }

    private static int[] countAlphabet(String s) {
        int[] alphabet = new int[ALPHABET_COUNT];

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() / 2 && s.length() % 2 == 1) {
                continue;
            }
            alphabet[s.charAt(i) - ALPHABET_START]++;
        }

        return alphabet;
    }
}
