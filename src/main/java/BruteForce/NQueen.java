/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9663
 * Cheat Level: 0
 * Algorithm: Backtracking
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    final static int QUEEN = 1;
    final static int EMPTY = 0;
    static int count = 0;
    static int N;
    static int[][] BOARD;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        BOARD = new int[N][N];

        solution(0);
        System.out.println(count);
    }

    private static void solution(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if (checkPossible(depth, y)) {
                BOARD[depth][y] = QUEEN;
                solution(depth + 1);
                BOARD[depth][y] = EMPTY;
            }
        }
    }

    private static boolean checkPossible(int x, int y) {
        return checkHeight(y) && checkDiagonal(x, y);
    }

    private static boolean checkHeight(int y) {
        for (int i = 0; i < N; i++) {
            if (BOARD[i][y] == QUEEN) return false;
        }
        return true;
    }

    private static boolean checkDiagonal(int x, int y) {
        int sum = x + y;
        int sub = x - y;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + j == sum && BOARD[i][j] == QUEEN) return false;
                if (i - j == sub && BOARD[i][j] == QUEEN) return false;
            }
        }
        return true;
    }
}
