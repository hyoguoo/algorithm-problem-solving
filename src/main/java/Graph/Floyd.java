/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11404
 * Cheat Level: 3
 * Algorithm: Graph / Floyd Warshall
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Floyd {

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        setGraph(bufferedReader);
        solution();
        printGraph();
    }

    private static void printGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == Integer.MAX_VALUE) stringBuilder.append(0).append(" ");
                else stringBuilder.append(graph[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void solution() {
        for (int via = 0; via < N; via++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if (graph[start][via] != Integer.MAX_VALUE && graph[via][end] != Integer.MAX_VALUE) {
                        graph[start][end] = Math.min(graph[start][end], graph[start][via] + graph[via][end]);
                    }
                }
            }
        }
    }

    private static void setGraph(BufferedReader bufferedReader) throws IOException {
        initGraph();
        int length = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = info[0] - 1;
            int end = info[1] - 1;
            int cost = info[2];
            graph[start][end] = Math.min(graph[start][end], cost);
        }
    }

    private static void initGraph() {
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
