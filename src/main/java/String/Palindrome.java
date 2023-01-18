/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17609
 * Cheat Level: 0
 * Algorithm: String / Two Pointer
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String string = bufferedReader.readLine();
            stringBuilder.append(isPalindromeString(string, 0, string.length() - 1, false)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int isPalindromeString(String string, int left, int right, boolean isSkip) {
        String reverseString = getReverseString(string);
        if (string.equals(reverseString)) return 0;

        while (left <= right) {
            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);
            if (leftChar == rightChar) {
                left++;
                right--;
            } else if (!isSkip) {
                int leftSkip = isPalindromeString(string, left + 1, right, true);
                int rightSkip = isPalindromeString(string, left, right - 1, true);
                return Math.min(leftSkip, rightSkip);
            } else {
                return 2;
            }
        }

        return 1;
    }

    private static String getReverseString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) stringBuilder.append(input.charAt(i));
        return stringBuilder.toString();
    }
}
