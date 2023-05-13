/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9252
 * Cheat Level: 4
 * Algorithm: Dynamic Programming / LCS / String
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String longestCommonSubsequence = getLongestCommonSubsequence(bufferedReader.readLine(), bufferedReader.readLine());
        System.out.println(longestCommonSubsequence.length());
        System.out.println(longestCommonSubsequence);
    }

    private static String getLongestCommonSubsequence(String string1, String string2) {
        int string1Length = string1.length();
        int string2Length = string2.length();
        int[][] dp = new int[string1Length + 1][string2Length + 1];

        for (int i = 1; i <= string1Length; i++) {
            for (int j = 1; j <= string2Length; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return getString(string1, string2, dp);
    }

    private static String getString(String string1, String string2, int[][] dp) {
        StringBuilder stringBuilder = new StringBuilder();
        int string1Length = string1.length();
        int string2Length = string2.length();

        while (string1Length > 0 && string2Length > 0) {
            if (dp[string1Length][string2Length] == dp[string1Length - 1][string2Length]) string1Length--;
            else if (dp[string1Length][string2Length] == dp[string1Length][string2Length - 1]) string2Length--;
            else {
                stringBuilder.append(string1.charAt(string1Length - 1));
                string1Length--;
                string2Length--;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
