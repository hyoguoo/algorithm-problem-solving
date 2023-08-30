/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 12일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.*;
import java.util.*;

public class Generator {

    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    final static int HOUSE = 1;
    final static int VISIT = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for (int n = 0; n < N; n++) {
            graph[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(graph));
    }

    private static int solution(int[][] graph) {
        int count = 0;

        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] == HOUSE) {
                    bfs(graph, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] graph, int n, int m) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (graph[current.n][current.m] == VISIT) continue;
            graph[current.n][current.m] = VISIT;

            for (int[] direction: DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM, graph.length, graph[n].length)) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }
    }

    private static boolean isInBound(int n, int m, int N, int M) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate (int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
