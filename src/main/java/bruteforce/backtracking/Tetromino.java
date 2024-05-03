/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14500
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tetromino {

    private static final int LIMIT = 4;
    private static final int[][] DIRECTIONS = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        int[][] board = parseBoard();

        System.out.print(solution(board));
    }

    private static int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int n = 0; n < board.length; n++) {
            for (int m = 0; m < board[0].length; m++) {
                visited[n][m] = true;
                dfs(board, n, m, 1, board[n][m], visited);
                visited[n][m] = false;
            }
        }

        return max;
    }

    private static void dfs(
            int[][] board,
            int currentN,
            int currentM,
            int count,
            int sum,
            boolean[][] visited
    ) {
        if (count == LIMIT) {
            max = Math.max(max, sum);
            return;
        }

        if (count == 2) {
            max = Math.max(
                    max,
                    sum + calculateSumOfThree(board, currentN, currentM, visited)
            );
        }

        for (int[] direction : DIRECTIONS) {
            int nextN = currentN + direction[0];
            int nextM = currentM + direction[1];

            if (isInBound(board, nextN, nextM) && !visited[nextN][nextM]) {
                visited[nextN][nextM] = true;
                dfs(board, nextN, nextM, count + 1, sum + board[nextN][nextM], visited);
                visited[nextN][nextM] = false;
            }
        }
    }

    private static int calculateSumOfThree(
            int[][] board,
            int currentN,
            int currentM,
            boolean[][] visited
    ) {
        int sumOfThree = 0;
        int min = Integer.MAX_VALUE;
        int countOfThree = 0;

        for (int[] direction : DIRECTIONS) {
            int nextN = currentN + direction[0];
            int nextM = currentM + direction[1];

            if (isInBound(board, nextN, nextM) && !visited[nextN][nextM]) {
                sumOfThree += board[nextN][nextM];
                min = Math.min(min, board[nextN][nextM]);
                countOfThree++;
            }
        }

        if (countOfThree == 2) {
            return sumOfThree;
        } else {
            return sumOfThree - min;
        }
    }

    private static boolean isInBound(int[][] board, int n, int m) {
        return 0 <= n && n < board.length &&
                0 <= m && m < board[0].length;
    }

    private static int[][] parseBoard() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        int[][] board = new int[sizeN][sizeM];

        for (int n = 0; n < sizeN; n++) {
            board[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return board;
    }
}
