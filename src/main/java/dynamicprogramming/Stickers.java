/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9465
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Stickers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseCount; i++) {
            int length = Integer.parseInt(bufferedReader.readLine());
            int[][] stickers = new int[2][length];
            stickers[0] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stickers[1] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(getMaxScore(stickers, length));
        }
    }

    private static int getMaxScore(int[][] stickers, int length) {
        int[][] dp = new int[3][length + 1];
        dp[0][1] = stickers[0][0];
        dp[1][1] = stickers[1][0];
        dp[2][1] = 0;

        for (int i = 2; i <= length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + stickers[0][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + stickers[1][i - 1];
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }

        return Math.max(dp[0][length], dp[1][length]);
    }
}
