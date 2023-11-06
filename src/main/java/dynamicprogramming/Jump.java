/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1890
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Jump {

    static final int[][] DIRECTION = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(board));
    }

    private static long solution(int[][] board) {
        long[][] dp = new long[board.length][board.length];
        dp[0][0] = 1;

        for (int n = 0; n < board.length; n++) {
            for (int m = 0; m < board[n].length; m++) {
                jump(board, dp, n, m);
            }
        }

        return dp[board.length - 1][board.length - 1];
    }

    private static void jump(int[][] board, long[][] dp, int n, int m) {
        if (dp[n][m] == 0 ||
            (n == board.length - 1 && m == board[n].length - 1)) return;

        for (int[] direction : DIRECTION) {
            int nextN = n + (board[n][m] * direction[0]);
            int nextM = m + (board[n][m] * direction[1]);
            if (!isInBound(board, n, nextN, nextM)) continue;
            dp[nextN][nextM] += dp[n][m];
        }
    }

    private static boolean isInBound(int[][] board, int n, int nextN, int nextM) {
        return nextN < board.length && nextM < board[n].length;
    }
}
