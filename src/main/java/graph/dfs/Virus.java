/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2606
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final int START_VERTEX = 1;

    public static void main(String[] args) throws IOException {
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        int edgeCount = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, List<Integer>> adjacentVertices = initializeAdjacentVertices(edgeCount);

        System.out.println(solution(adjacentVertices, vertexCount));
    }

    private static Map<Integer, List<Integer>> initializeAdjacentVertices(int edgeCount) throws IOException {
        Map<Integer, List<Integer>> adjacentVertices = new HashMap<>();

        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjacentVertices.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            adjacentVertices.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        return adjacentVertices;
    }

    private static int solution(Map<Integer, List<Integer>> adjacentVertices, int vertexCount) {
        boolean[] visited = new boolean[vertexCount + 1];
        visited[START_VERTEX] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(START_VERTEX);

        int visitCount = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            visitCount++;

            for (Integer next : adjacentVertices.getOrDefault(current, Collections.emptyList())) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }

        return visitCount - 1;
    }
}
