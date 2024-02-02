/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2206 / 14442
 * Cheat Level: 2
 * Algorithm: Graph / BFS
 */

/* Key Point
처음에는 Backtracking 방식으로 접근하여 정답을 구할 수 있었으나, 시간초과가 발생.
모든 벽에 대해 부수는 경우와 부수지 않는 경우를 모두 탐색해야 하기 때문에 시간초과가 발생한 것으로 보임.
따라서, 3차원 배열을 사용하여 접근
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreakWallGo {

    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final int WALL = -1;
    static final int EMPTY = 0;
    static final int START_N = 0;
    static final int START_M = 0;
    static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int breakLimit = info[2];
        int[][][] map = new int[breakLimit + 1][n][m];

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(line[j]);
                if (value == 1) value = WALL;
                for (int k = 0; k <= breakLimit; k++) map[k][i][j] = value;
            }
        }
        System.out.println(bfs(map, n, m, breakLimit));
    }

    private static int bfs(int[][][] map, int n, int m, int breakLimit) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(START_N, START_M, 0, 1));

        map[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.n == n - 1 && current.m == m - 1) return current.distance;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(n, m, nextN, nextM)) continue;

                if (current.depth < breakLimit &&
                    map[current.depth][nextN][nextM] == WALL) {
                    for (int depth = current.depth + 1; depth <= breakLimit; depth++) {
                        if (map[depth][nextN][nextM] == WALL) {
                            map[depth][nextN][nextM] = current.distance + 1;
                            queue.add(new Coordinate(nextN, nextM, depth, current.distance + 1));
                        }
                    }
                }

                if (map[current.depth][nextN][nextM] == EMPTY) {
                    for (int depth = current.depth; depth <= breakLimit; depth++) {
                        map[depth][nextN][nextM] = current.distance + 1;
                    }
                    queue.add(new Coordinate(nextN, nextM, current.depth, current.distance + 1));
                }
            }
        }

        return NOT_FOUND;
    }

    private static boolean isInBound(int limitN, int limitM, int n, int m) {
        return 0 <= n && n < limitN && 0 <= m && m < limitM;
    }

    static class Coordinate {
        int n;
        int m;
        int depth;
        int distance;

        public Coordinate(int n, int m, int depth, int distance) {
            this.n = n;
            this.m = m;
            this.depth = depth;
            this.distance = distance;
        }
    }
}
