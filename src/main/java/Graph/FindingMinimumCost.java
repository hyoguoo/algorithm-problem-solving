/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1916
 * Cheat Level: 2
 * Algorithm: Graph / Dijkstra
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindingMinimumCost {

    static int[][] graph;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        EDGE_COUNT = Integer.parseInt(bufferedReader.readLine());

        graph = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];
        for (int[] row : graph) Arrays.fill(row, -1);
        for (int index = 0; index < EDGE_COUNT; index++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            initGraph(edgeInfo);
        }

        int[] goalInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = goalInfo[0];
        int end = goalInfo[1];
        int[] costFromStart = dijkstra(start);

        System.out.println(costFromStart[end]);
    }

    private static int[] dijkstra(int start) {
        int[] costFromStart = new int[VERTEX_COUNT + 1];
        Arrays.fill(costFromStart, Integer.MAX_VALUE);
        costFromStart[start] = 0;

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(start, 0));

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        while (!priorityQueue.isEmpty()) {
            Vertex poll = priorityQueue.poll();
            int currentIndex = poll.index;
            int currentCost = poll.cost;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (int nextIndex = 1; nextIndex <= VERTEX_COUNT; nextIndex++) {
                int nextCost = graph[currentIndex][nextIndex];
                if (nextCost == -1) continue;

                int newCost = currentCost + nextCost;
                if (costFromStart[nextIndex] > newCost) {
                    costFromStart[nextIndex] = newCost;
                    priorityQueue.add(new Vertex(nextIndex, newCost));
                }
            }
        }

        return costFromStart;
    }

    private static void initGraph(int[] edgeInfo) {
        int start = edgeInfo[0];
        int end = edgeInfo[1];
        int cost = edgeInfo[2];

        if (graph[start][end] == -1 || graph[start][end] > cost) graph[start][end] = cost;
    }

    static class Vertex implements Comparable<Vertex> {
        int index;
        int cost;

        public Vertex(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }
}
