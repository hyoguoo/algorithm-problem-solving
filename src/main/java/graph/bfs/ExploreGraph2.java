/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14218
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class ExploreGraph2 {

    private static final int MAIN_VERTEX = 0;
    private static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int vertexCount = info[0];
        int initEdgeCount = info[1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < initEdgeCount; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        int newEdgeCount = Integer.parseInt(bufferedReader.readLine());
        Edge[] additionalEdges = new Edge[newEdgeCount];

        for (int i = 0; i < newEdgeCount; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            additionalEdges[i] = new Edge(from, to);
        }

        System.out.print(solution(graph, additionalEdges, vertexCount));
    }

    private static String solution(Map<Integer, List<Integer>> graph, Edge[] additionalEdges, int vertexCount) {
        List<int[]> result = Arrays.stream(additionalEdges)
                .map(additionalEdge -> {
                    addAdditionalEdge(graph, additionalEdge);
                    return bfs(graph, vertexCount);
                }).collect(Collectors.toList());

        return result.stream()
                .map(distances -> Arrays.stream(distances)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    private static void addAdditionalEdge(Map<Integer, List<Integer>> graph, Edge additionalEdge) {
        int from = additionalEdge.from;
        int to = additionalEdge.to;
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    private static int[] bfs(Map<Integer, List<Integer>> graph, int vertexCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(MAIN_VERTEX);

        int[] distances = Arrays.stream(new int[vertexCount])
                .map(i -> NOT_VISITED)
                .toArray();
        distances[MAIN_VERTEX] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            graph.getOrDefault(current, new ArrayList<>()).stream()
                    .filter(neighbor -> distances[neighbor] == NOT_VISITED)
                    .forEach(neighbor -> {
                        distances[neighbor] = distances[current] + 1;
                        queue.add(neighbor);
                    });
        }

        return distances;
    }

    static class Edge {

        private final int from;
        private final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
