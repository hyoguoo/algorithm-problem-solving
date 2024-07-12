/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24446
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

public class AlgorithmLessonBFS3 {

    static final int NOT_VISITED = -1;

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

        printResult(solution(graph, vertexCount, startVertex));
    }

    private static void printResult(int[] solution) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < solution.length; i++) {
            stringBuilder.append(solution[i]).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int[] solution(
            Map<Integer, List<Integer>> graph,
            int vertexCount,
            int startVertex
    ) {
        int[] depth = new int[vertexCount + 1];
        Arrays.fill(depth, NOT_VISITED);
        Deque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(startVertex, 0));
        depth[startVertex] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.getVertex();

            for (Integer next : graph.getOrDefault(current, new ArrayList<>())) {
                if (depth[next] != NOT_VISITED) {
                    continue;
                }
                queue.add(new Node(next, node.getDepth() + 1));
                depth[next] = node.getDepth() + 1;
            }
        }

        return depth;
    }

    static class Node {
        private final int vertex;
        private final int depth;

        public Node(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }

        public int getVertex() {
            return vertex;
        }

        public int getDepth() {
            return depth;
        }
    }
}
