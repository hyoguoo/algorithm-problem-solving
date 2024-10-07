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

            for (Direction direction: Direction.values()) {
                Coordinate nextCoordinate = current.next(direction);

                if (!isInBound(nextCoordinate, board)) {
                    continue;
                }

                int newBreakCount = breakCount[current.n][current.m]
                        + (board[nextCoordinate.n][nextCoordinate.m] == WALL ? 1 : 0);

                if (newBreakCount < breakCount[nextCoordinate.n][nextCoordinate.m]) {
                    breakCount[nextCoordinate.n][nextCoordinate.m] = newBreakCount;
                    queue.add(new Coordinate(nextCoordinate.n, nextCoordinate.m, newBreakCount));
                }
            }
        }

        return breakCount[board.length - 1][board[0].length - 1];
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int n;
        private final int m;

        Direction(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }

    private static boolean isInBound(Coordinate coordinate, int[][] board) {
        return 0 <= coordinate.n && coordinate.n < board.length
                && 0 <= coordinate.m && coordinate.m < board[0].length;
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

        public Coordinate next(Direction direction) {
            return new Coordinate(this.n + direction.getN(), this.m + direction.getM(), this.breakCount);
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
