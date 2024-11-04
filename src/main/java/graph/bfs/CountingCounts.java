/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2644
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
import java.util.stream.IntStream;

public class CountingCounts {

    static final int NOT_VISIT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());

        int[] queryInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Query query = new Query(queryInfo[0], queryInfo[1]);

        int edgeCount = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        System.out.print(solution(graph, query, vertexCount));
    }

    private static int solution(Map<Integer, List<Integer>> graph, Query query, int vertexCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(query.start);

        int[] distance = IntStream.range(0, vertexCount + 1)
                .map(i -> NOT_VISIT)
                .toArray();
        distance[query.start] = 0;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            int currentDistance = distance[currentVertex];

            graph.getOrDefault(currentVertex, new ArrayList<>())
                    .stream()
                    .filter(vertex -> distance[vertex] == NOT_VISIT)
                    .forEach(vertex -> {
                        distance[vertex] = currentDistance + 1;
                        queue.add(vertex);
                    });
        }

        return distance[query.end];
    }

    static class Query {

        private final int start;
        private final int end;

        public Query(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
