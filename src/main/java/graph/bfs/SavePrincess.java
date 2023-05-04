/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17836
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

public class SavePrincess {

    final static int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, M, LIMIT_TIME;
    static int GRAM_X, GRAM_Y;
    static int answer = 10001;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        LIMIT_TIME = info[2];
        map = new int[N][M];

        for (int x = 0; x < N; x++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int y = 0; y < M; y++) {
                map[x][y] = line[y];
                if (map[x][y] == 2) {
                    GRAM_X = x;
                    GRAM_Y = y;
                    map[x][y] = 0;
                } else if (map[x][y] == 1) {
                    map[x][y] = -1;
                }
            }
        }

        bfs();
        System.out.println(answer > LIMIT_TIME ? "Fail" : answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentTime = current.time;

            if (currentX == GRAM_X && currentY == GRAM_Y) {
                answer = currentTime + getManhattanDistance(N - 1, M - 1, GRAM_X, GRAM_Y);
                continue;
            }
            if (currentX == N - 1 && currentY == M - 1) {
                answer = Math.min(answer, currentTime);
                return;
            }

            for (int[] direction : DIRECTION) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                if (isInMap(nextX, nextY) && map[nextX][nextY] != -1 && (map[nextX][nextY] == 0 || map[nextX][nextY] > currentTime + 1)) {
                    map[nextX][nextY] = currentTime + 1;
                    queue.add(new Node(nextX, nextY, currentTime + 1));
                }
            }
        }
    }

    private static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean isInMap(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
}
