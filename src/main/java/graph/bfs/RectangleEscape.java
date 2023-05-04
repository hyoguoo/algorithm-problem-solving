/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16973
 * Cheat Level: 2
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RectangleEscape {

    final static int WALL = -1;
    final static int NOT_VISIT = 0;
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, H, W, START_X, START_Y, END_X, END_Y;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(START_X, START_Y, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDistance = current.distance;

            if (currentX == END_X && currentY == END_Y) return GRAPH[END_X][END_Y];

            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (!checkBorder(nextX, nextY)) continue;
                if (GRAPH[nextX][nextY] != NOT_VISIT) continue;
                GRAPH[nextX][nextY] = currentDistance + 1;
                queue.add(new Node(nextX, nextY, currentDistance + 1));
            }
        }

        return -1;
    }

    private static boolean checkBorder(int nextX, int nextY) {
        if (nextX + H - 1 >= N || nextY + W - 1 >= M) return false;
        for (int offsetX = 0; offsetX < H; offsetX++) {
            if (GRAPH[nextX + offsetX][nextY] == WALL) return false;
            if (GRAPH[nextX + offsetX][nextY + W - 1] == WALL) return false;
        }
        for (int offsetY = 0; offsetY < W; offsetY++) {
            if (GRAPH[nextX][nextY + offsetY] == WALL) return false;
            if (GRAPH[nextX + H - 1][nextY + offsetY] == WALL) return false;
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        GRAPH = new int[N][M];
        for (int n = 0; n < N; n++) {
            int[] values = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < values.length; m++) {
                int value = values[m];
                GRAPH[n][m] = value == 1 ? WALL : 0;
            }
        }
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        H = info[0];
        W = info[1];
        START_X = info[2] - 1;
        START_Y = info[3] - 1;
        END_X = info[4] - 1;
        END_Y = info[5] - 1;
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
