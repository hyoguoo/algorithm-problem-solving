/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18126
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RaccoonGooGoo {

    private static final int START_VERTEX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        int edgeCount = vertexCount - 1;
        Edge[] edges = new Edge[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            edges[i] = new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]);
        }

        System.out.print(solution(edges, vertexCount));
    }

    private static long solution(Edge[] edges, int vertexCount) {
        long[][] graph = new long[vertexCount + 1][vertexCount + 1];
        for (Edge edge : edges) {
            graph[edge.start][edge.end] = edge.distance;
            graph[edge.end][edge.start] = edge.distance;
        }

        boolean[] visited = new boolean[vertexCount + 1];
        visited[START_VERTEX] = true;

        return dfs(graph, START_VERTEX, visited, 0);
    }

    private static long dfs(long[][] graph, int currentVertex, boolean[] visited, long distance) {
        long maxDistance = distance;

        for (int nextVertex = 1; nextVertex < graph.length; nextVertex++) {
            long nextDistance = graph[currentVertex][nextVertex];
            if (!visited[nextVertex] && nextDistance != 0) {
                visited[nextVertex] = true;
                maxDistance = Math.max(
                        maxDistance,
                        dfs(graph, nextVertex, visited, distance + nextDistance)
                );
                visited[nextVertex] = false;
            }
        }
        return maxDistance;
    }

    static class Edge {

        private final int start;
        private final int end;
        private final int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
