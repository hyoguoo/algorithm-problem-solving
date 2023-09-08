/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 19일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlternatePaths {

    static int vertexCount, edgeCount, startVertex, endVertex;
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws Exception {
        init();
        solution();
    }

    private static void solution() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int v = 1; v <= vertexCount; v++) {
            stringBuilder.append(bfs(v)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int bfs(int inavailableVertex) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(startVertex, 1));

        boolean[] visited = new boolean[vertexCount + 1];
        visited[inavailableVertex] = true;

        while (!queue.isEmpty()) {
            Move current = queue.poll();

            if (visited[current.vertex]) continue;
            visited[current.vertex] = true;

            if (current.vertex == endVertex) return current.distance;

            for (int next : edgeList[current.vertex]) {
                queue.add(new Move(next, current.distance + 1));
            }
        }

        return -1;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vertexCount = info[0];
        edgeCount = info[1];
        startVertex = info[2];
        endVertex = info[3];
        edgeList = new ArrayList[vertexCount + 1];
        for (int i = 0; i < edgeList.length; i++) edgeList[i] = new ArrayList<>();

        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edgeList[edgeInfo[0]].add(edgeInfo[1]);
            edgeList[edgeInfo[1]].add(edgeInfo[0]);
        }
    }

    static class Move {
        int vertex;
        int distance;

        public Move(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
