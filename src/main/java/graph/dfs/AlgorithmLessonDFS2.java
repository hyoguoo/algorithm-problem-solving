/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 244480
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

public class AlgorithmLessonDFS2 {

    private static final int NOT_VISITED = 0;
    private static int visitCount = 1;

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

        printArray(solution(graph, vertexCount, startVertex));
    }

    private static int[] solution(
            Map<Integer, List<Integer>> graph,
            int vertexCount,
            int startVertex
    ) {
        graph.forEach((k, v) -> v.sort((a, b) -> b - a));
        int[] visits = new int[vertexCount + 1];
        dfs(graph, startVertex, visits);

        return visits;
    }

    private static void dfs(
            Map<Integer, List<Integer>> graph,
            int currentVertex,
            int[] visits
    ) {
        visits[currentVertex] = visitCount++;

        for (int nextVertex : graph.getOrDefault(currentVertex, new ArrayList<>())) {
            if (visits[nextVertex] == NOT_VISITED) {
                dfs(graph, nextVertex, visits);
            }
        }
    }

    private static void printArray(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }
}
