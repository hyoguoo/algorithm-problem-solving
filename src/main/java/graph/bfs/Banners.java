/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14716
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

public class Banners {

    static final int EXIST = 1;
    static final int EMPTY = 0;

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = info[0];
        int m = info[1];
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.print(solution(graph));
    }

    private static int solution(int[][] graph) {
        int count = 0;

        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                int value = graph[n][m];
                if (value == EXIST) {
                    bfs(graph, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] graph, int startN, int startM) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM, graph) ||
                    graph[nextN][nextM] == EMPTY) continue;
                queue.add(new Coordinate(nextN, nextM));
                graph[nextN][nextM] = EMPTY;
            }
        }
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
