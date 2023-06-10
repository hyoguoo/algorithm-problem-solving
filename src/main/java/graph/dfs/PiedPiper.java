/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16724
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PiedPiper {

    final static char UP = 'U';
    final static char DOWN = 'D';
    final static char LEFT = 'L';
    final static char RIGHT = 'R';
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (visited[n][m]) continue;
                dfs(n, m, new ArrayList<>(List.of(new Coordinate(n, m))));
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int n, int m, List<Coordinate> path) {
        if (visited[n][m]) return;
        visited[n][m] = true;

        int[] direction = getDirection(graph[n][m]);
        int nextN = n + direction[0];
        int nextM = m + direction[1];

        if (path.contains(new Coordinate(nextN, nextM))) {
            answer++;
            return;
        }

        path.add(new Coordinate(nextN, nextM));
        dfs(nextN, nextM, path);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = sizeInfo[0];
        M = sizeInfo[1];
        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
    }

    private static int[] getDirection(char c) {
        switch (c) {
            case DOWN:
                return DIRECTIONS[0];
            case RIGHT:
                return DIRECTIONS[1];
            case UP:
                return DIRECTIONS[2];
            case LEFT:
                return DIRECTIONS[3];
        }
        throw new IllegalArgumentException();
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Coordinate)) return false;
            Coordinate coordinate = (Coordinate) obj;
            return this.n == coordinate.n && this.m == coordinate.m;
        }

        @Override
        public int hashCode() {
            return this.n * 1000 + this.m;
        }
    }
}
