/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5972
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PackageDelivery {

    private static final int START_VERTEX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int vertexCount = info[0];
        int edgeCount = info[1];
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int cost = edgeInfo[2];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, cost));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(from, cost));
        }

        System.out.print(solution(graph, vertexCount));
    }

    private static int solution(Map<Integer, List<Edge>> graph, int vertexCount) {
        int[] dijkstra = dijkstra(graph, vertexCount);
        return dijkstra[vertexCount];
    }

    private static int[] dijkstra(Map<Integer, List<Edge>> graph, int vertexCount) {
        int[] distance = new int[vertexCount + 1];
        for (int i = 0; i <= vertexCount; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[START_VERTEX] = 0;

        boolean[] visited = new boolean[vertexCount + 1];

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        priorityQueue.add(new Edge(START_VERTEX, 0));

        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            int current = poll.to;
            int currentCost = poll.cost;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Edge edge : graph.getOrDefault(current, new ArrayList<>())) {
                int next = edge.to;
                int nextCost = edge.cost;
                int newDistance = currentCost + nextCost;
                if (distance[next] > newDistance) {
                    distance[next] = newDistance;
                    priorityQueue.add(new Edge(next, newDistance));
                }
            }
        }

        return distance;
    }

    static class Edge {

        private final int to;
        private final int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
