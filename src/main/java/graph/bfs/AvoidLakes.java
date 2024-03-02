/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1743
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

public class AvoidLakes {

    static final int[][] DIRECTIONS = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static final int LAKE = -1;
    static final int VISITED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int m = info[1];
        int lakeCount = info[2];
        int[][] graph = new int[n][m];

        while (lakeCount-- > 0) {
            int[] lakeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[lakeInfo[0] - 1][lakeInfo[1] - 1] = LAKE;
        }

        System.out.print(solution(graph));
    }

    private static int solution(int[][] graph) {
        int max = 0;

        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] == LAKE) {
                    max = Math.max(max, bfs(graph, n, m));
                }
            }
        }

        return max;
    }

    private static int bfs(int[][] graph, int startN, int startM) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(startN, startM));
        graph[startN][startM] = VISITED;
        int visitedCount = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            visitedCount++;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(graph.length, graph[0].length, nextN, nextM) ||
                        graph[nextN][nextM] != LAKE) {
                    continue;
                }

                queue.add(new Coordinate(nextN, nextM));
                graph[nextN][nextM] = VISITED;
            }
        }

        return visitedCount;
    }

    private static boolean isInBound(int limitN, int limitM, int nextN, int nextM) {
        return 0 <= nextN && nextN < limitN && 0 <= nextM && nextM < limitM;
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
