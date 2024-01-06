/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2665
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CreateMaze {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int WALL = 0;
    static final int ROAD = 1;
    static final int START_N = 0;
    static final int START_M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(START_N, START_M));
        int[][] breakCount = new int[board.length][board[0].length];
        for (int[] row : breakCount) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        breakCount[START_N][START_M] = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM, board) ||
                    breakCount[nextN][nextM] <= breakCount[current.n][current.m]) continue;

                if (board[nextN][nextM] == ROAD) breakCount[nextN][nextM] = breakCount[current.n][current.m];
                else if (board[nextN][nextM] == WALL) breakCount[nextN][nextM] = breakCount[current.n][current.m] + 1;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return breakCount[board.length - 1][board[0].length - 1];
    }

    private static boolean isInBound(int n, int m, int[][] board) {
        return 0 <= n && n < board.length && 0 <= m && m < board[0].length;
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
