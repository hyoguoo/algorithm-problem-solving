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
import java.util.Objects;
import java.util.PriorityQueue;

public class CreateMaze {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int WALL = 0;
    static final int START_N = 0;
    static final int START_M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(board));
    }

    private static int solution(int[][] board) {
        PriorityQueue<Coordinate> queue = new PriorityQueue<>();
        queue.add(new Coordinate(START_N, START_M, 0));
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

                if (!isInBound(nextN, nextM, board)) {
                    continue;
                }

                int newBreakCount = breakCount[current.n][current.m]
                        + (board[nextN][nextM] == WALL ? 1 : 0);

                if (newBreakCount < breakCount[nextN][nextM]) {
                    breakCount[nextN][nextM] = newBreakCount;
                    queue.add(new Coordinate(nextN, nextM, newBreakCount));
                }
            }
        }

        return breakCount[board.length - 1][board[0].length - 1];
    }

    private static boolean isInBound(int n, int m, int[][] board) {
        return 0 <= n && n < board.length
                && 0 <= m && m < board[0].length;
    }

    static class Coordinate implements Comparable<Coordinate> {

        private final int n;
        private final int m;
        private final int breakCount;

        public Coordinate(int n, int m, int breakCount) {
            this.n = n;
            this.m = m;
            this.breakCount = breakCount;
        }

        @Override
        public int compareTo(Coordinate other) {
            return Integer.compare(this.breakCount, other.breakCount);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return n == that.n && m == that.m && breakCount == that.breakCount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m, breakCount);
        }
    }
}
