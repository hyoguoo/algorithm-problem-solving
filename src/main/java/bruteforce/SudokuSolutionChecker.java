/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9291
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SudokuSolutionChecker {

    private static final int BOARD_SIZE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int t = 1; t <= testCount; t++) {
            int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                board[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            bufferedReader.readLine();
            stringBuilder.append(String.format("Case %d: ", t))
                    .append(solution(board) ? "CORRECT" : "INCORRECT")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int[][] board) {
        return checkRows(board) && checkColumns(board) && checkSubGrids(board);
    }

    private static boolean checkRows(int[][] board) {
        return checkBoard(board, (b, i, j) -> b[i][j]);
    }

    private static boolean checkColumns(int[][] board) {
        return checkBoard(board, (b, i, j) -> b[j][i]);
    }

    private static boolean checkBoard(int[][] board, ValueProvider valueProvider) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean[] visited = new boolean[BOARD_SIZE + 1];
            for (int j = 0; j < BOARD_SIZE; j++) {
                int value = valueProvider.getValue(board, i, j);
                if (visited[value]) {
                    return false;
                }
                visited[value] = true;
            }
        }
        return true;
    }

    private static boolean checkSubGrids(int[][] board) {
        for (int grid = 0; grid < BOARD_SIZE; grid++) {
            if (!checkSubGrid(board, grid)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSubGrid(int[][] board, int gridIndex) {
        int startRow = (gridIndex / 3) * 3;
        int startCol = (gridIndex % 3) * 3;
        boolean[] visited = new boolean[BOARD_SIZE + 1];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[startRow + i][startCol + j];
                if (visited[value]) {
                    return false;
                }
                visited[value] = true;
            }
        }
        return true;
    }

    interface ValueProvider {

        int getValue(int[][] board, int i, int j);
    }
}
