/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8892
 * Cheat Level: 0
 * Algorithm: String / Brute Force
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int wordCount = Integer.parseInt(bufferedReader.readLine());
            String[] words = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                words[i] = bufferedReader.readLine();
            }
            stringBuilder.append(solution(words)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String combinedWord1 = words[i] + words[j];
                if (isPalindrome(combinedWord1)) {
                    return combinedWord1;
                }
                String combinedWord2 = words[j] + words[i];
                if (isPalindrome(combinedWord2)) {
                    return combinedWord2;
                }
            }
        }
        return "0";
    }

    private static boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
