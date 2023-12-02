/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24444
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlgorithmLessonBFS1 {

    static final int NOT_VISITED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int vertexCount = info[0];
        int edgeCount = info[1];
        int startVertex = info[2];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        printArray(solution(graph, vertexCount, startVertex));
    }

    private static int[] solution(Map<Integer, List<Integer>> graph, int vertexCount, int startVertex) {
        for (List<Integer> adjacentVertices : graph.values()) {
            Collections.sort(adjacentVertices);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertexCount + 1];

        queue.add(startVertex);
        int visitCount = 0;
        visited[startVertex] = ++visitCount;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                if (visited[next] != NOT_VISITED) continue;
                queue.add(next);
                visited[next] = ++visitCount;
            }
        }

        return visited;
    }

    private static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            stringBuilder.append(array[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
