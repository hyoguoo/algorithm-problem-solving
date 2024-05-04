/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2615
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gomoku {

    private static final int EMPTY = 0;
    private static final int COMPLTE_COUNT = 5;
    private static final int BOARD_SIZE = 19;
    private static final int[][] DIRECTIONS = {
            {0, 1},
            {1, 0},
            {1, 1},
            {1, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int n = 0; n < BOARD_SIZE; n++) {
            board[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(board));
    }

    private static String solution(int[][] board) {
        for (int m = 0; m < BOARD_SIZE; m++) {
            for (int n = 0; n < BOARD_SIZE; n++) {
                if (board[n][m] == EMPTY) {
                    continue;
                }

                if (isCompleted(board, n, m)) {
                    return board[n][m] + "\n" + (n + 1) + " " + (m + 1);
                }
            }
        }

        return "0";
    }

    private static boolean isCompleted(int[][] board, int n, int m) {
        int color = board[n][m];

        for (int[] direction : DIRECTIONS) {
            int count = 1;
            int nextN = n + direction[0];
            int nextM = m + direction[1];

            while (isInBound(board, nextN, nextM) &&
                    board[nextN][nextM] == color) {
                count++;
                nextN += direction[0];
                nextM += direction[1];
            }

            nextN = n - direction[0];
            nextM = m - direction[1];

            while (isInBound(board, nextN, nextM) &&
                    board[nextN][nextM] == color) {
                count++;
                nextN -= direction[0];
                nextM -= direction[1];
            }

            if (count == COMPLTE_COUNT) {
                return true;
            }
        }

        return false;
    }

    private static boolean isInBound(int[][] board, int n, int m) {
        return 0 <= n && n < board.length &&
                0 <= m && m < board[0].length;
    }
}
