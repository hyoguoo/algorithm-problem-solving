/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 13일차
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

public class Generator2 {

    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    final static int VISIT = -1;
    final static int[] counts = new int[30 + 1];
    static int[][] graph;
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        for (int n = 0; n < graph.length; n++) {
            for (int m = 0; m < graph[n].length; m++) {
                if (graph[n][m] != VISIT) {
                    int sectionNumber = graph[n][m];
                    int sectionCount = bfs(n, m, sectionNumber);
                    if (sectionCount >= K) counts[sectionNumber]++;
                }
            }
        }

        return getMaxCountSectionNumber();
    }

    private static int getMaxCountSectionNumber() {
        int maxCount = Arrays.stream(counts).max().orElseThrow();

        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == maxCount) return i;
        }

        return -1;
    }

    private static int bfs(int n, int m, int sectionNumber) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));
        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (graph[current.n][current.m] != sectionNumber) continue;
            graph[current.n][current.m] = VISIT;
            count++;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM)) continue;
                queue.add(new Coordinate(nextN, nextM));
            }
        }

        return count;
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        K = info[1];
        graph = new int[N][N];
        for (int n = 0; n < N; n++) {
            graph[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
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
