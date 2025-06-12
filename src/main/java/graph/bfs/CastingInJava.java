/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25601
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CastingInJava {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int edgeCount = Integer.parseInt(bufferedReader.readLine()) - 1;

        Edge[] edges = new Edge[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            String[] edgeData = bufferedReader.readLine().split(" ");
            edges[i] = new Edge(edgeData[0], edgeData[1]);
        }

        String[] queryInfo = bufferedReader.readLine().split(" ");
        Query query = new Query(queryInfo[0], queryInfo[1]);

        System.out.print(solution(edges, query) ? 1 : 0);
    }

    private static boolean solution(Edge[] edges, Query query) {
        Map<String, Set<String>> graph = generateGraph(edges);

        return bfs(graph, query.class1, query.class2) ||
                bfs(graph, query.class2, query.class1);
    }

    private static boolean bfs(Map<String, Set<String>> graph, String from, String to) {
        Queue<String> queue = new LinkedList<>();
        queue.add(from);
        Set<String> visited = new HashSet<>();
        visited.add(from);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(to)) {
                return true;
            }

            for (String neighbor : graph.getOrDefault(current, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    private static Map<String, Set<String>> generateGraph(Edge[] edges) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (Edge edge : edges) {
            graph.computeIfAbsent(edge.from, k -> new HashSet<>()).add(edge.to);
        }
        return graph;
    }

    static class Query {

        private final String class1;
        private final String class2;

        public Query(String class1, String class2) {
            this.class1 = class1;
            this.class2 = class2;
        }
    }

    static class Edge {

        private final String from;
        private final String to;

        public Edge(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }
}
