/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2606
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Virus {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        int edgeCount = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[vertexCount + 1];
        int[][] edges = new int[edgeCount][2];
        for (int i = 0; i < edgeCount; i++) edges[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(edges, 1);
        System.out.println(countVisitedVertex() - 1);
    }

    private static int countVisitedVertex() {
        int count = 0;
        for (boolean b : visited) if (b) count++;
        return count;
    }

    private static void dfs(int[][] edges, int currentVertex) {
        visited[currentVertex] = true;
        for (int[] edge : edges) {
            if (edge[0] == currentVertex && !visited[edge[1]]) {
                visited[edge[1]] = true;
                dfs(edges, edge[1]);
            }
            if (edge[1] == currentVertex && !visited[edge[0]]) {
                visited[edge[0]] = true;
                dfs(edges, edge[0]);
            }
        }
    }
}
