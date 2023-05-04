/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1389
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SixDegreesOfSeparations {

    final static List<Integer> result = new ArrayList<>();
    static int vertexCount;
    static int edgeCount;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vertexCount = info[0];
        edgeCount = info[1];
        graph = new int[vertexCount + 1][vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        for (int i = 1; i <= vertexCount; i++) bfs(i);

        Integer min = Collections.min(result);
        System.out.println(result.indexOf(min) + 1);
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visitCount = new int[vertexCount + 1];
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 1; i <= vertexCount; i++) {
                if (graph[poll][i] == 1 && visitCount[i] == 0) {
                    visitCount[i] = visitCount[poll] + 1;
                    queue.add(i);
                }
            }
        }

        result.add(getSum(visitCount, vertex));
    }

    private static int getSum(int[] visitCount, int vertex) {
        int sum = 0;
        for (int i = 1; i <= vertexCount; i++) {
            if (vertex != i) sum += visitCount[i];
        }
        return sum;
    }
}
