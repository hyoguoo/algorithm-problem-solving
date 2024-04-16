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

public class ElectingPresident {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, List<Integer>> adjacentVertices = new HashMap<>();

        while (true) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (edgeInfo[0] == -1 && edgeInfo[1] == -1) {
                break;
            }
            adjacentVertices.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            adjacentVertices.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        solution(adjacentVertices, n);
    }

    private static void solution(Map<Integer, List<Integer>> adjacentVertices, int n) {
        int[] distances = new int[n + 1];
        int minDistance = Integer.MAX_VALUE;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            distances[i] = bfs(adjacentVertices, i, n);
            minDistance = Math.min(minDistance, distances[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (distances[i] == minDistance) {
                candidates.add(i);
            }
        }

        System.out.println(minDistance + " " + candidates.size());
        candidates.forEach(candidate -> System.out.print(candidate + " "));
    }

    private static int bfs(Map<Integer, List<Integer>> adjacentVertices, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        int distance = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer current = queue.poll();

                for (Integer next : adjacentVertices.getOrDefault(current, new ArrayList<>())) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
            distance++;
        }

        return distance - 1;
    }
}
