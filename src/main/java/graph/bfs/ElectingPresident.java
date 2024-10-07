/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2660
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
import java.util.stream.IntStream;

public class ElectingPresident {

    private static final int END_SIGNAL = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        while (true) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (edgeInfo[0] == END_SIGNAL && edgeInfo[1] == END_SIGNAL) {
                break;
            }
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        System.out.print(solution(graph, vertexCount));
    }

    private static String solution(Map<Integer, List<Integer>> graph, int vertexCount) {
        int[] distances = calculateDistances(graph, vertexCount);
        int minDistance = getMinDistance(distances, vertexCount);
        int[] candidates = findCandidates(vertexCount, distances, minDistance);

        return formatResult(candidates, minDistance);
    }

    private static int[] calculateDistances(Map<Integer, List<Integer>> graph, int vertexCount) {
        int[] distances = new int[vertexCount + 1];

        IntStream.rangeClosed(1, vertexCount)
                .forEach(v -> distances[v] = bfs(graph, v, vertexCount));

        return distances;
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int startVertex, int vertexCount) {
        boolean[] visited = new boolean[vertexCount + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        int distance = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer current = queue.poll();

                for (Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
            distance++;
        }

        return distance;
    }

    private static int getMinDistance(int[] distances, int vertexCount) {
        return IntStream.rangeClosed(1, vertexCount)
                .map(i -> distances[i])
                .min()
                .orElseThrow();
    }

    private static int[] findCandidates(int vertexCount, int[] distances, int minDistance) {
        return IntStream.rangeClosed(1, vertexCount)
                .filter(i -> distances[i] == minDistance)
                .toArray();
    }

    private static String formatResult(int[] candidates, int minDistance) {
        return minDistance + " " + candidates.length + "\n" +
                Arrays.stream(candidates)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
    }
}
