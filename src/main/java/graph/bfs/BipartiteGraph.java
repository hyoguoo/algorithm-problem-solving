/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1707
 * Cheat Level: 2
 * Algorithm: BFS / Graph / Bipartite Graph
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BipartiteGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < testCase; t++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int vertexCount = info[0];
            int edgeCount = info[1];
            List<Integer>[] graph = new ArrayList[vertexCount + 1];
            for (int v = 0; v <= vertexCount; v++) graph[v] = new ArrayList<>();

            for (int e = 0; e < edgeCount; e++) {
                int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[edgeInfo[0]].add(edgeInfo[1]);
                graph[edgeInfo[1]].add(edgeInfo[0]);
            }

            stringBuilder.append(solution(graph, vertexCount) ? "YES" : "NO").append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static boolean solution(List<Integer>[] graph, int vertexCount) {
        Color[] bipartite = new Color[vertexCount + 1];

        for (int v = 1; v <= vertexCount; v++) {
            if (bipartite[v] != null) continue;
            if (!bfs(graph, bipartite, v)) return false;
        }

        return true;
    }

    private static boolean bfs(List<Integer>[] graph, Color[] bipartite, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bipartite[start] = Color.RED;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (bipartite[next] == bipartite[current]) return false;
                if (bipartite[next] == null) {
                    queue.add(next);
                    bipartite[next] = bipartite[current] == Color.RED ? Color.BLACK : Color.RED;
                }
            }
        }

        return true;
    }

    enum Color {
        RED, BLACK
    }
}
