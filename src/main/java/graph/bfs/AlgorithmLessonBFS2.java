/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24445
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmLessonBFS2 {

    static final int NOT_VISITED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int vertexCount = info[0];
        int edgeCount = info[1];
        int startVertex = info[2];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }
        for (List<Integer> adjacentVertices : graph.values()) {
            adjacentVertices.sort((a, b) -> b - a);
        }

        printResult(solution(graph, vertexCount, startVertex));
    }

    private static void printResult(int[] solution) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < solution.length; i++) {
            stringBuilder.append(solution[i]).append(" ");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int[] solution(
            Map<Integer, List<Integer>> graph,
            int vertexCount,
            int startVertex
    ) {
        int[] visited = new int[vertexCount + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int visitCount = 1;

        queue.add(startVertex);
        visited[startVertex] = visitCount++;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                if (visited[next] != NOT_VISITED) {
                    continue;
                }
                queue.add(next);
                visited[next] = visitCount++;
            }
        }

        return visited;
    }
}
