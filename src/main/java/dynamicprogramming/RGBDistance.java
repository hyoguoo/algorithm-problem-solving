/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1149
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGBDistance {

    static int[][] rgbList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        rgbList = new int[length][3];

        for (int i = 0; i < length; i++) {
            int[] rgb = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rgbList[i] = rgb;
        }

        int[][] dp = solution(length);

        int min = getMin(length, dp);
        System.out.println(min);
    }

    private static int getMin(int length, int[][] dp) {
        int min = dp[length - 1][0];
        for (int i = 1; i < 3; i++) {
            if (min > dp[length - 1][i]) min = dp[length - 1][i];
        }
        return min;
    }

    private static int[][] solution(int length) {
        int[][] dp = new int[length][3];
        dp[0] = rgbList[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgbList[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgbList[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgbList[i][2];
        }
        return dp;
    }
}
