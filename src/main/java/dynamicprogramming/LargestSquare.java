/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1915
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestSquare {

    static final int NOT_EXIST = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[info[0]][info[1]];
        for (int i = 0; i < info[0]; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(board));
    }

    private static int solution(int[][] dp) {
        int max = 0;

        for (int n = 1; n < dp.length; n++) {
            for (int m = 1; m < dp[n].length; m++) {
                if (dp[n][m] == NOT_EXIST) continue;
                if (dp[n - 1][m - 1] > NOT_EXIST &&
                    dp[n - 1][m] > NOT_EXIST &&
                    dp[n][m - 1] > NOT_EXIST) {
                    dp[n][m] = Math.min(Math.min(dp[n - 1][m - 1], dp[n - 1][m]), dp[n][m - 1]) + 1;
                    max = Math.max(max, dp[n][m]);
                }
            }
        }

        return max > 0 ? max * max : findMin(dp);
    }

    private static int findMin(int[][] dp) {
        for (int[] line : dp) {
            for (int i : line) {
                if (i > NOT_EXIST) return i;
            }
        }

        return NOT_EXIST;
    }
}
