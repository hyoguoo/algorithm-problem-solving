/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2573
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

public class Icebergs {

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int WATER = 0;
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int result = 0;

        while (true) {
            if (isAllMelted()) return 0;

            result++;

            int[][] tempMap = copyMap();
            calculateIcebergState(tempMap);
            map = tempMap;

            if (getBfsCount() >= 2) return result;
        }
    }

    private static boolean isAllMelted() {
        int count = 0;

        for (int[] row : map) {
            for (int col : row) {
                if (col != WATER) count++;
            }
        }

        return count == 0;
    }

    private static void calculateIcebergState(int[][] tempMap) {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (tempMap[n][m] == WATER) continue;
                int adjacentWaterCount = getAdjacentWaterCount(n, m);
                tempMap[n][m] = Math.max(tempMap[n][m] - adjacentWaterCount, 0);
            }
        }
    }

    private static int getAdjacentWaterCount(int n, int m) {
        int count = 0;

        for (int[] direction : DIRECTIONS) {
            int nextN = n + direction[0];
            int nextM = m + direction[1];
            if (!isInBound(nextN, nextM)) continue;
            if (map[nextN][nextM] == WATER) count++;
        }

        return count;
    }

    private static int getBfsCount() {
        boolean[][] visited = new boolean[N][M];
        int bfsCount = 0;

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visited[n][m] && map[n][m] != WATER) {
                    bfs(n, m, visited);
                    bfsCount++;
                }
            }
        }
        return bfsCount;
    }

    private static void bfs(int n, int m, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(n, m));
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (!isInBound(nextN, nextM)
                        || visited[nextN][nextM]
                        || map[nextN][nextM] == WATER) continue;

                queue.add(new Coordinate(nextN, nextM));
                visited[nextN][nextM] = true;
            }
        }
    }

    private static boolean isInBound(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    private static int[][] copyMap() {
        int[][] tempMap = new int[N][M];
        for (int n = 0; n < N; n++) {
            tempMap[n] = Arrays.copyOf(map[n], M);
        }
        return tempMap;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            map[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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
