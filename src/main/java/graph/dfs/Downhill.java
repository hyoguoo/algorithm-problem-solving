/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1520
 * Cheat Level: 4
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Downhill {

    final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    final static int NOT_VISITED = -1;
    static int N, M;
    static int[][] GRAPH;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        int count = dfs(0, 0);
        System.out.println(count);
    }

    private static int dfs(int n, int m) {
        if (dp[n][m] != NOT_VISITED) {
            return dp[n][m];
        }
        if (n == N - 1 && m == M - 1) {
            return 1;
        }

        int count = 0;
        for (int[] DIRECTION : DIRECTIONS) {
            int nextN = n + DIRECTION[0];
            int nextM = m + DIRECTION[1];
            if (nextN < 0 || nextM < 0 || nextN >= N || nextM >= M) continue;
            if (GRAPH[nextN][nextM] >= GRAPH[n][m]) continue;
            count += dfs(nextN, nextM);
        }

        dp[n][m] = count;
        return count;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        GRAPH = new int[N][M];
        dp = new int[N][M];
        for (int n = 0; n < N; n++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < M; m++) {
                GRAPH[n][m] = line[m];
                dp[n][m] = NOT_VISITED;
            }
        }
    }
}
