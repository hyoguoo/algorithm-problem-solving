/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1937
 * Cheat Level: 4
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyPanda {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] graph = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.print(solution(graph));
    }

    private static int solution(int[][] graph) {
        int[][] dp = initArray(graph);
        int max = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                max = Math.max(max, dfs(graph, dp, i, j));
            }
        }

        return max;
    }

    private static int[][] initArray(int[][] graph) {
        int[][] array = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(array[i], NOT_VISITED);
        }
        return array;
    }

    private static int dfs(int[][] graph, int[][] dp, int n, int m) {
        if (dp[n][m] != NOT_VISITED) {
            return dp[n][m];
        }

        dp[n][m] = 1;

        for (int[] direction : DIRECTIONS) {
            int nextN = n + direction[0];
            int nextM = m + direction[1];

            if (!isInBound(graph, nextN, nextM)) continue;

            if (graph[n][m] < graph[nextN][nextM]) {
                dp[n][m] = Math.max(dp[n][m], dfs(graph, dp, nextN, nextM) + 1);
            }
        }

        return dp[n][m];
    }

    private static boolean isInBound(int[][] graph, int n, int m) {
        return 0 <= n && n < graph.length && 0 <= m && m < graph.length;
    }
}
