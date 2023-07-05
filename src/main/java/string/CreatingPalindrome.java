/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1213
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatingPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String src = bufferedReader.readLine();
        System.out.println(solution(src));

    }

    private static String solution(String src) {
        int[] counts = getCountAlphabet(src);

        if (!validatePalindromeCount(counts)) return "I'm Sorry Hansoo";

        return getPalindromeString(counts).toString();
    }

    private static StringBuilder getPalindromeString(int[] counts) {
        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for (int i = 0; i < counts.length; i++) {
            char character = (char) ('A' + i);
            int count = counts[i];
            String repeat = String.valueOf(character).repeat(count / 2);

            if (count % 2 == 1) middle.append(character);
            left.append(repeat);
            right.append(repeat);
        }

        left.append(middle).append(right.reverse());

        return left;
    }

    private static boolean validatePalindromeCount(int[] counts) {
        boolean isOdd = false;

        for (int count : counts) {
            if (count % 2 == 1) {
                if (isOdd) return false;
                isOdd = true;
            }
        }

        return true;
    }

    private static int[] getCountAlphabet(String src) {
        int[] count = new int[26];

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            count[c - 'A']++;
        }
        return count;
    }
}
