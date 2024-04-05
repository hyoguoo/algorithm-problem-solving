/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2210
 * Cheat Level: 0
 * Algorithm: Graph / DFS / Brute Force
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JumpingNumberBoard {

    static final int SIZE = 5;
    static final int MOVE_LIMIT = 6;
    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final Set<String> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseBoard()));
    }

    private static int[][] parseBoard() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[SIZE][SIZE];

        for (int n = 0; n < SIZE; n++) {
            board[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return board;
    }

    private static int solution(int[][] board) {
        for (int n = 0; n < SIZE; n++) {
            for (int m = 0; m < SIZE; m++) {
                dfs(board, new Coordinate(n, m), new StringBuilder().append(board[n][m]));
            }
        }
        return numberSet.size();
    }

    private static void dfs(int[][] board, Coordinate coordinate, StringBuilder numberString) {
        if (numberString.length() == MOVE_LIMIT) {
            numberSet.add(numberString.toString());
            return;
        }

        for (int[] direction : DIRECTIONS) {
            int nextN = coordinate.n + direction[0];
            int nextM = coordinate.m + direction[1];

            if (!isInBound(nextN, nextM)) {
                continue;
            }

            dfs(board, new Coordinate(nextN, nextM), numberString.append(board[nextN][nextM]));
            numberString.deleteCharAt(numberString.length() - 1);
        }
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < SIZE && 0 <= m && m < SIZE;
    }

    static class Coordinate {

        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
