/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13565
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

public class Percolation {

    static final int CONNECTED = 0;
    static final int NOT_CONNECTED = 1;
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        System.out.println(solution(initiaialzedGraph())
                ? "YES"
                : "NO");
    }

    private static int[][] initiaialzedGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        return graph;
    }

    private static boolean solution(int[][] graph) {
        return bfs(graph, initializedQueue(graph));
    }

    private static boolean bfs(int[][] graph, Queue<Coordinate> queue) {
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(graph, new Coordinate(nextN, nextM))) continue;
                if (isReachBottom(graph, new Coordinate(nextN, nextM))) return true;
                if (graph[nextN][nextM] == CONNECTED) {
                    queue.add(new Coordinate(nextN, nextM));
                    graph[nextN][nextM] = NOT_CONNECTED;
                }
            }
        }

        return false;
    }

    private static boolean isInBound(int[][] graph, Coordinate coordinate) {
        return 0 <= coordinate.n && coordinate.n < graph.length &&
               0 <= coordinate.m && coordinate.m < graph[0].length;
    }

    private static boolean isReachBottom(int[][] graph, Coordinate coordinate) {
        return coordinate.n == graph.length - 1;
    }

    private static Queue<Coordinate> initializedQueue(int[][] graph) {
        Queue<Coordinate> queue = new LinkedList<>();

        for (int m = 0; m < graph[0].length; m++) {
            if (graph[0][m] == CONNECTED) {
                queue.add(new Coordinate(0, m));
                graph[0][m] = NOT_CONNECTED;
            }
        }

        return queue;
    }

    static class Coordinate {
        int n;
        int m;

        Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
