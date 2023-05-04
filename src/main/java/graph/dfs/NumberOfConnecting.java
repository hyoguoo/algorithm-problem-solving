/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11724
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfConnecting {

    static int vertexCount;
    static int edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        vertexCount = Integer.parseInt(input[0]);
        edgeCount = Integer.parseInt(input[1]);

        int[][] graph = new int[vertexCount + 1][vertexCount + 1];
        boolean[] visited = new boolean[vertexCount + 1];
        for (int i = 0; i < edgeCount; i++) {
            String[] edge = bufferedReader.readLine().split(" ");
            int vertex1 = Integer.parseInt(edge[0]);
            int vertex2 = Integer.parseInt(edge[1]);
            graph[vertex1][vertex2] = 1;
            graph[vertex2][vertex1] = 1;
        }

        System.out.println(countElement(graph, visited));
    }

    private static int countElement(int[][] graph, boolean[] visited) {
        int count = 0;

        while (true) {
            int vertex = 0;
            for (int i = 1; i <= vertexCount; i++) {
                if (!visited[i]) {
                    vertex = i;
                    break;
                }
            }
            if (vertex == 0) break;
            dfs(graph, visited, vertex);
            count++;
        }

        return count;
    }

    private static void dfs(int[][] graph, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int i = 1; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) dfs(graph, visited, i);
        }
    }
}
