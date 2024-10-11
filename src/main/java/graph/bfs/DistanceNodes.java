/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1240
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

public class DistanceNodes {

    private static final int NOT_CONNECTED = 0;
    private static final int NOT_VISITED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int nodeCount = info[0];
        int[][] graph = new int[nodeCount + 1][nodeCount + 1];

        for (int i = 0; i < nodeCount - 1; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        int queryCount = info[1];
        Query[] queries = new Query[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int[] query = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            queries[i] = new Query(query[0], query[1]);
        }

        System.out.print(solution(graph, queries));
    }

    private static String solution(int[][] graph, Query[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = bfs(graph, queries[i].from, queries[i].to);
        }

        return Arrays.stream(result)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }

    private static int bfs(int[][] graph, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[graph.length];
        queue.add(from);
        distance[from] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int next = 1; next < graph[current].length; next++) {
                if (graph[current][next] == NOT_CONNECTED || distance[next] != NOT_VISITED) {
                    continue;
                }
                distance[next] = distance[current] + graph[current][next];
                queue.add(next);
            }
        }

        return distance[to];
    }

    static class Query {

        private final int from;
        private final int to;

        public Query(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
