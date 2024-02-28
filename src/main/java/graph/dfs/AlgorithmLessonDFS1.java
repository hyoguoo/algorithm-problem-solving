/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 244479
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

public class AlgorithmLessonDFS1 {

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
        graph.forEach((k, v) -> v.sort(Integer::compareTo));
        boolean[] isVisited = new boolean[vertexCount + 1];
        List<Integer> visitedList = new ArrayList<>();
        dfs(graph, startVertex, isVisited, visitedList);

        return getVisitedSequence(vertexCount, visitedList);
    }

    private static void dfs(
            Map<Integer, List<Integer>> graph,
            int currentVertex,
            boolean[] isVisited,
            List<Integer> visitedList
    ) {
        isVisited[currentVertex] = true;
        visitedList.add(currentVertex);

        for (int nextVertex : graph.getOrDefault(currentVertex, new ArrayList<>())) {
            if (!isVisited[nextVertex]) {
                dfs(graph, nextVertex, isVisited, visitedList);
            }
        }
    }

    private static int[] getVisitedSequence(int vertexCount, List<Integer> visitedList) {
        int[] visitedSequence = new int[vertexCount + 1];

        for (int i = 0; i < visitedList.size(); i++) {
            int vertex = visitedList.get(i);
            visitedSequence[vertex] = i + 1;
        }

        return visitedSequence;
    }

    private static void printArray(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }
}

/*
5 3 2
2 3
2 4
3 4
 */
