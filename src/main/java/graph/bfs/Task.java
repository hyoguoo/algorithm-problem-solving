/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21937
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

public class Task {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int vertexCount = info[0];
        int edgeCount = info[1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        int target = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(graph, target, vertexCount));
    }

    private static int solution(Map<Integer, List<Integer>> graph, int target, int vertexCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        boolean[] isVisited = new boolean[vertexCount + 1];

        int count = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int next : graph.getOrDefault(current, new ArrayList<>())) {
                if (!isVisited[next]) {
                    queue.add(next);
                    isVisited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
