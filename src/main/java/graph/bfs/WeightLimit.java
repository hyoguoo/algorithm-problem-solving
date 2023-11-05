/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1939
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeightLimit {

    static final int LIMIT = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodeCount = info[0];
        int edgeCount = info[1];
        List<Edge>[] edges = new List[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) edges[i] = new LinkedList<>();


        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int weight = edgeInfo[2];
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        int[] startEnd = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = startEnd[0];
        int end = startEnd[1];

        System.out.println(solution(edges, start, end));
    }

    private static int solution(List<Edge>[] edges, int start, int end) {
        int min = 0;
        int max = LIMIT;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (bfs(edges, start, end, mid)) min = mid + 1;
            else max = mid - 1;
        }

        return max;
    }

    private static boolean bfs(List<Edge>[] edges, int start, int end, int weight) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) return true;

            for (Edge edge : edges[current]) {
                if (edge.weight < weight ||
                    visited[edge.to]) continue;
                visited[edge.to] = true;
                queue.add(edge.to);
            }
        }

        return false;
    }

    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
