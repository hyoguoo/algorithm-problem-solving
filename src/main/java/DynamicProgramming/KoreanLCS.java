/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15482
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KoreanLCS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        System.out.println(getLongestCommonSubstring(str1, str2));
    }

    private static int getLongestCommonSubstring(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        for (int i = 1; i <= str1Length; i++) {
            for (int j = 1; j <= str2Length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[str1Length][str2Length];
    }
}
