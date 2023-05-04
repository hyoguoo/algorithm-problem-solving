/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2589
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

public class TreasureIsland {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) == 'L' ? 0 : -1;
            }
        }

        System.out.println(getMax());
    }

    private static int getMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        return max;
    }

    private static int bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        int[][] copyMap = copyMap();
        int max = 0;

        queue.add(new Node(i, j, 0));
        copyMap[i][j] = 1;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDistance = current.distance;

            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                int nextDistance = currentDistance + 1;
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (copyMap[nextX][nextY] != 0) continue;
                max = Math.max(max, nextDistance);
                copyMap[nextX][nextY] = nextDistance;
                queue.add(new Node(nextX, nextY, nextDistance));
            }
        }

        return max;
    }

    private static int[][] copyMap() {
        return Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
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
