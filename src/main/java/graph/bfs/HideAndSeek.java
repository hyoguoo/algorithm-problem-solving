/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6118
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek {

    static final int START_VERTEX = 1;
    static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int vertexCount = info[0];
        int edgeCount = info[1];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        solution(graph, vertexCount);
    }

    private static void solution(Map<Integer, List<Integer>> graph, int vertexCount) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertexCount + 1];
        Arrays.fill(visited, NOT_VISITED);

        queue.add(START_VERTEX);
        visited[START_VERTEX] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                if (visited[next] == NOT_VISITED) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }

        printResult(visited);
    }

    private static void printResult(int[] visited) {
        int maxDistance = getMaxDistance(visited);
        int maxDistanceVertexWithMinIndex = getVertexWithMinIndex(visited, maxDistance);
        long maxDistanceCount = countMaxDistanceVisits(visited, maxDistance);

        System.out.print(maxDistanceVertexWithMinIndex + " " + maxDistance + " " + maxDistanceCount);
    }

    private static int getMaxDistance(int[] visited) {
        return Arrays.stream(visited).max().orElseThrow();
    }

    private static int getVertexWithMinIndex(int[] visited, int maxDistance) {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == maxDistance) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    private static long countMaxDistanceVisits(int[] visited, int maxDistance) {
        return Arrays.stream(visited)
                .filter(v -> v == maxDistance)
                .count();
    }
}
