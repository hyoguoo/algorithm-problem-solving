/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14496
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

public class TheeBecomingThat {

    private static final int NOT_CONNECTED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] goalInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int from = goalInfo[0];
        int to = goalInfo[1];
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int vertexCount = sizeInfo[0];
        int edgeCount = sizeInfo[1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int start = edgeInfo[0];
            int end = edgeInfo[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            graph.computeIfAbsent(end, k -> new ArrayList<>()).add(start);
        }

        System.out.print(solution(graph, from, to, vertexCount));
    }

    private static int solution(Map<Integer, List<Integer>> graph, int from, int to, int vertexCount) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[vertexCount + 1];

        queue.add(new Node(from, 0));
        isVisited[from] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.vertex == to) {
                return current.distance;
            }

            for (int next : graph.getOrDefault(current.vertex, new ArrayList<>())) {
                if (!isVisited[next]) {
                    queue.add(new Node(next, current.distance + 1));
                    isVisited[next] = true;
                }
            }
        }

        return NOT_CONNECTED;
    }

    static class Node {

        private final int vertex;
        private final int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
