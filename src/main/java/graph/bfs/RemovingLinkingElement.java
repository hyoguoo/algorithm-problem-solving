/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 20일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RemovingLinkingElement {

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N, K, Q;
    static String[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        K = info[1];
        Q = info[2];
        board = new String[N][N];
        for (int n = 0; n < N; n++) board[n] = bufferedReader.readLine().split("");

        for (int q = 0; q < Q; q++) {
            String[] qInfo = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(qInfo[0]) - 1;
            int m = Integer.parseInt(qInfo[1]) - 1;
            String value = qInfo[2];
            bfs(n, m, value);
        }

        printBoard();
    }

    private static void bfs(int startN, int startM, String value) {
        board[startN][startM] = value;

        List<Coordinate> visitedList = new ArrayList<>();

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (visitedList.contains(new Coordinate(current.n, current.m))) continue;
            visitedList.add(new Coordinate(current.n, current.m));

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM)) continue;
                if (!board[nextN][nextM].equals(value)) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        if (visitedList.size() < K) return;

        for (Coordinate visited : visitedList) {
            board[visited.n][visited.m] = ".";
        }
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }

    private static void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                stringBuilder.append(board[n][m]);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate coordinate = (Coordinate) o;
            return n == coordinate.n && m == coordinate.m;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + n;
            result = prime * result + m;
            return result;
        }
    }
}

