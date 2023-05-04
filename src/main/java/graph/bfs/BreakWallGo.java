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

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    final static int WALL = -1;
    final static int EMPTY = 0;
    static int BREAK_LIMIT;
    static int N, M;
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        BREAK_LIMIT = info[2];
        map = new int[BREAK_LIMIT + 1][N][M];

        for (int i = 0; i < N; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(line[j]);
                if (value == 1) value = WALL;
                for (int k = 0; k <= BREAK_LIMIT; k++) map[k][i][j] = value;
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 1));
        map[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDepth = current.depth;
            int currentDistance = current.distance;
            if (currentX == N - 1 && currentY == M - 1) {
                return currentDistance;
            }
            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (currentDepth < BREAK_LIMIT && map[currentDepth][nextX][nextY] == WALL) {
                    for (int depth = currentDepth + 1; depth <= BREAK_LIMIT; depth++) {
                        if (map[depth][nextX][nextY] == WALL) {
                            map[depth][nextX][nextY] = currentDistance + 1;
                            queue.add(new Point(nextX, nextY, depth, currentDistance + 1));
                        }
                    }
                }
                if (map[currentDepth][nextX][nextY] == EMPTY) {
                    for (int depth = currentDepth; depth <= BREAK_LIMIT; depth++) {
                        map[depth][nextX][nextY] = currentDistance + 1;
                    }
                    queue.add(new Point(nextX, nextY, currentDepth, currentDistance + 1));
                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;
        int depth;
        int distance;

        Point(int x, int y, int depth, int distance) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.distance = distance;
        }
    }
}
