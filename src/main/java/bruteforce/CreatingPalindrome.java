/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1254
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatingPalindrome {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) return s.length() + i;
        }

        return s.length() * 2;
    }

    private static boolean isPalindrome(String substring) {
        return substring.contentEquals(new StringBuilder(substring).reverse());
    }
}
