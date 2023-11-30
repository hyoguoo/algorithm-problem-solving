/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1926
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Picture {

    static final int VISITED = -1;
    static final int EXIST = 1;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution(graph);
    }

    private static void solution(int[][] graph) {
        int count = 0;
        int max = 0;

        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] == EXIST) {
                    count++;
                    max = Math.max(max, bfs(graph, n, m));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(int[][] graph, int startN, int startM) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));
        int count = 0;
        graph[startN][startM] = VISITED;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            count++;

            for (int[] direction : DIRECTIONS) {
                int nextN = coordinate.n + direction[0];
                int nextM = coordinate.m + direction[1];
                if (isInBound(nextN, nextM, graph) && graph[nextN][nextM] == EXIST) {
                    graph[nextN][nextM] = VISITED;
                    queue.add(new Coordinate(nextN, nextM));
                }
            }
        }
        return count;
    }

    private static boolean isInBound(int n, int m, int[][] graph) {
        return 0 <= n && n < graph.length && 0 <= m && m < graph[n].length;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
