/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 16일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Union {
    static int vertexCount, edgeCount;
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        boolean[] visited = new boolean[vertexCount + 1];
        int count = 0;

        for (int i = 1; i <= vertexCount; i++) {
            if (!visited[i]) {
                bfs(i, visited);
                count++;
            }
        }

        return count;
    }

    private static void bfs(int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (visited[current]) continue;
            visited[current] = true;

            for (Integer next : edgeList[current]) {
                if (!edgeList[next].contains(current)) continue;
                queue.add(next);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vertexCount = info[0];
        edgeCount = info[1];
        edgeList = new ArrayList[vertexCount + 1];
        for (int i = 0; i < edgeList.length; i++) edgeList[i] = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            edgeList[from].add(to);
        }
    }
}