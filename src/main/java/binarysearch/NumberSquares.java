/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1051
 * Cheat Level: 0
 * Algorithm:
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSquares {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int maxSquareSize = 0;

        for (int n = 0; n < board.length; n++) {
            for (int m = 0; m < board[n].length; m++) {
                maxSquareSize = Math.max(maxSquareSize, getMaxSquareSize(board, n, m));
            }
        }

        return maxSquareSize;
    }

    private static int getMaxSquareSize(int[][] board, int n, int m) {
        int maxDistance = Math.min(board.length - n, board[n].length - m);

        while (maxDistance-- > 0) {
            if (!isInBound(board, n + maxDistance, m + maxDistance)) continue;
            if (board[n][m] == board[n + maxDistance][m]
                    && board[n][m] == board[n][m + maxDistance]
                    && board[n][m] == board[n + maxDistance][m + maxDistance]) {
                return (maxDistance + 1) * (maxDistance + 1);
            }
        }

        return 1;
    }

    private static boolean isInBound(int[][] board, int n, int m) {
        return 0 <= n && n < board.length && 0 <= m && m < board[n].length;
    }
}
