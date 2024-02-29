/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23835
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MilkDeliveredEasy {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int vertexCount = Integer.parseInt(BUFFERED_READER.readLine());
        Map<Integer, List<Integer>> graph = generateGraph(vertexCount);
        Query[] queries = parseQueries();

        solution(graph, vertexCount, queries);
    }

    private static void solution(
            Map<Integer, List<Integer>> graph,
            int vertexCount,
            Query[] queries
    ) {
        List<Integer> result = new ArrayList<>();
        int[] deliveryQuantities = new int[vertexCount + 1];

        for (Query query : queries) {
            if (query instanceof DeliveryQuery) {
                DeliveryQuery deliveryQuery = (DeliveryQuery) query;
                boolean[] visited = new boolean[vertexCount + 1];
                delivery(
                        graph,
                        deliveryQuantities,
                        new ArrayList<>(),
                        visited,
                        deliveryQuery.startVertex,
                        deliveryQuery.endVertex,
                        0
                );
            } else if (query instanceof CountQuery) {
                CountQuery countQuery = (CountQuery) query;
                result.add(countDeliverable(deliveryQuantities, countQuery.vertex));
            } else {
                throw new IllegalArgumentException("Invalid query type");
            }
        }

        printList(result);
    }

    private static void delivery(
            Map<Integer, List<Integer>> graph,
            int[] deliveryQuantities,
            List<DeliveryInfo> deliveryInfos,
            boolean[] visited,
            int currentVertex,
            int endVertex,
            int depth
    ) {
        deliveryInfos.add(new DeliveryInfo(currentVertex, depth));
        visited[currentVertex] = true;

        if (currentVertex == endVertex) {
            calculateDeliveryQuantities(deliveryQuantities, deliveryInfos);
            return;
        }

        for (Integer nextVertex : graph.getOrDefault(currentVertex, new ArrayList<>())) {
            if (!visited[nextVertex]) {
                delivery(
                        graph,
                        deliveryQuantities,
                        deliveryInfos,
                        visited,
                        nextVertex,
                        endVertex,
                        depth + 1
                );
            }
        }

        visited[currentVertex] = false;
        deliveryInfos.remove(deliveryInfos.size() - 1);
    }

    private static void calculateDeliveryQuantities(
            int[] deliveryQuantities,
            List<DeliveryInfo> deliveryInfos
    ) {
        deliveryInfos.forEach(
                deliveryInfo -> deliveryQuantities[deliveryInfo.vertex] += deliveryInfo.depth
        );
    }

    private static int countDeliverable(int[] deliveryQuantities, int vertex) {
        return deliveryQuantities[vertex];
    }

    private static Map<Integer, List<Integer>> generateGraph(int vertexCount) throws IOException {
        int edgeCount = vertexCount - 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }
        return graph;
    }

    private static Query[] parseQueries() throws IOException {
        int queryCount = Integer.parseInt(BUFFERED_READER.readLine());
        Query[] queries = new Query[queryCount];

        for (int q = 0; q < queryCount; q++) {
            String[] queryInfo = BUFFERED_READER.readLine().split(" ");
            if (queryInfo[0].equals("1")) {
                queries[q] = new DeliveryQuery(Integer.parseInt(queryInfo[1]),
                        Integer.parseInt(queryInfo[2]));
            } else {
                queries[q] = new CountQuery(Integer.parseInt(queryInfo[1]));
            }
        }
        return queries;
    }

    private static void printList(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach(r -> stringBuilder.append(r).append("\n"));
        System.out.println(stringBuilder.toString().trim());
    }

    interface Query {

    }

    static class DeliveryQuery implements Query {

        int startVertex;
        int endVertex;

        public DeliveryQuery(int startVertex, int endVertex) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
        }
    }

    static class CountQuery implements Query {

        int vertex;

        public CountQuery(int vertex) {
            this.vertex = vertex;
        }
    }

    static class DeliveryInfo {

        int vertex;
        int depth;

        public DeliveryInfo(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }
    }
}
