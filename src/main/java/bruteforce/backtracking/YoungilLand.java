/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31871
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YoungilLand {

    private static long ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        int edgeCount = Integer.parseInt(bufferedReader.readLine());
        List<List<Edge>> adjancyList = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        boolean[] isVisited = new boolean[vertexCount + 1];

        for (int v = 0; v <= vertexCount + 1; v++) {
            adjancyList.add(new ArrayList<>());
            graph.put(v, new HashMap<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int weight = edgeInfo[2];

            Map<Integer, Integer> currentVertex = graph.get(from);
            if (currentVertex.containsKey(to)) {
                currentVertex.put(to, Math.max(currentVertex.get(to), weight));
            } else {
                currentVertex.put(to, weight);
            }
        }

        for (int v = 0; v <= vertexCount; v++) {
            Map<Integer, Integer> currentVertex = graph.get(v);

            for (int key : currentVertex.keySet()) {
                int currentWeight = currentVertex.get(key);
                adjancyList.get(v).add(new Edge(key, currentWeight));
            }
        }

        System.out.print(solution(adjancyList, isVisited, vertexCount));
    }

    private static long solution(
            List<List<Edge>> adjancyList,
            boolean[] isVisited,
            int vertexCount
    ) {
        dfs(0, 0, 0, adjancyList, isVisited, vertexCount);
        return ans;
    }

    private static void dfs(
            int currentVertex,
            int sum,
            int visitedCount,
            List<List<Edge>> adjancyList,
            boolean[] isVisited,
            int vertexCount
    ) {
        if (currentVertex == 0 && visitedCount == vertexCount + 1) {
            ans = Math.max(ans, sum);
            return;
        }

        for (Edge next : adjancyList.get(currentVertex)) {
            if (isVisited[next.to]) {
                continue;
            }

            isVisited[next.to] = true;
            dfs(next.to, sum + next.weight, visitedCount + 1, adjancyList, isVisited, vertexCount);
            isVisited[next.to] = false;
        }
    }

    private static class Edge {

        int to;
        int weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
