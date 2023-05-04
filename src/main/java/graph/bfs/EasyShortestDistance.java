/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14940
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

public class EasyShortestDistance {

    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int M;
    static int N;
    static int[][] graph;
    static Node target;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = info[0];
        N = info[1];
        graph = new int[M][N];

        for (int x = 0; x < M; x++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int y = 0; y < N; y++) {
                addGraph(x, y, line[y]);
            }
        }

        bfs();
        printMap();
    }

    private static void printMap() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (graph[x][y] == Integer.MAX_VALUE) stringBuilder.append(-1);
                else stringBuilder.append(graph[x][y]);
                if (y != N - 1) stringBuilder.append(" ");
            }
            if (x != M - 1) stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void addGraph(int x, int y, int value) {
        if (value == 2) {
            target = new Node(x, y, 0);
            graph[x][y] = 0;
        } else if (value != 0) {
            graph[x][y] = Integer.MAX_VALUE;
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.x;
            int currentY = poll.y;
            int currentDistance = poll.distance;

            for (int[] direction : DIRECTION) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if (graph[nextX][nextY] > currentDistance + 1) {
                    graph[nextX][nextY] = currentDistance + 1;
                    queue.add(new Node(nextX, nextY, currentDistance + 1));
                }
            }
        }
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
