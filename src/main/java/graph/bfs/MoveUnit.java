/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2194
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

public class MoveUnit {

    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final static int BLOCKED = -1;
    final static int EMPTY = 0;
    final static int VISITED = 1;
    static int[][] map;
    static int N;
    static int M;
    static int UNIT_SIZE_X;
    static int UNIT_SIZE_Y;
    static int CURRENT_X;
    static int CURRENT_Y;
    static int TARGET_X;
    static int TARGET_Y;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(CURRENT_X, CURRENT_Y, 0));
        map[CURRENT_X][CURRENT_Y] = VISITED;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == TARGET_X && current.y == TARGET_Y) return current.count;
            for (int[] direction : DIRECTIONS) {
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];
                if (isInBound(nextX, nextY) && map[nextX][nextY] == EMPTY) {
                    queue.add(new Point(nextX, nextY, current.count + 1));
                    map[nextX][nextY] = VISITED;
                }
            }
        }

        return -1;
    }

    private static boolean isInBound(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        for (int offsetX = 0; offsetX < UNIT_SIZE_X; offsetX++) {
            for (int offsetY = 0; offsetY < UNIT_SIZE_Y; offsetY++) {
                if (x + offsetX >= N || y + offsetY >= M || map[x + offsetX][y + offsetY] == BLOCKED) return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        map = new int[N][M];
        UNIT_SIZE_X = info[2];
        UNIT_SIZE_Y = info[3];
        int OBSTACLE_COUNT = info[4];
        for (int i = 0; i < OBSTACLE_COUNT; i++) {
            int[] obstacle = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[obstacle[0] - 1][obstacle[1] - 1] = BLOCKED;
        }
        int[] current = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        CURRENT_X = current[0] - 1;
        CURRENT_Y = current[1] - 1;
        int[] target = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TARGET_X = target[0] - 1;
        TARGET_Y = target[1] - 1;
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
