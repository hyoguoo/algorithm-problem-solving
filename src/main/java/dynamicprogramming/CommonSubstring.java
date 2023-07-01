/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5582
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / String
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommonSubstring {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray1 = bufferedReader.readLine().toCharArray();
        char[] charArray2 = bufferedReader.readLine().toCharArray();
        System.out.println(solution(charArray1, charArray2));
    }

    private static int solution(char[] charArray1, char[] charArray2) {
        int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];

        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (charArray1[i] == charArray2[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
            }
        }

        return getMaxValue(dp);
    }

    private static int getMaxValue(int[][] dp) {
        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().orElse(0);
    }
}
