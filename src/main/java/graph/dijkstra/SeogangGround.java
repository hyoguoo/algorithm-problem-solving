/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14938
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SeogangGround {

    final static int NOT_CONNECTED = -1;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;
    static int DISTANCE_LIMIT;
    static int[] ITEM_COUNT;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init();
        List<Integer> result = solution();

        System.out.println(Collections.max(result));
    }

    private static List<Integer> solution() {
        List<Integer> maxItemList = new ArrayList<>();

        for (int vertex = 1; vertex <= VERTEX_COUNT; vertex++) {
            int[] distanceFromVertex = dijkstra(vertex);
            int maxItem = getSumLessThanDistanceLimit(distanceFromVertex);
            maxItemList.add(maxItem);
        }

        return maxItemList;
    }

    private static int getSumLessThanDistanceLimit(int[] dijkstra) {
        int sum = 0;
        for (int index = 1; index <= VERTEX_COUNT; index++) {
            if (dijkstra[index] <= DISTANCE_LIMIT) sum += ITEM_COUNT[index - 1];
        }
        return sum;
    }

    private static int[] dijkstra(int start) {
        boolean[] visited = new boolean[VERTEX_COUNT + 1];
        int[] distanceFromStart = initDistance(start);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            int currentIndex = poll.end;
            int currentDistance = poll.distance;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (int i = 1; i <= VERTEX_COUNT; i++) {
                if (GRAPH[currentIndex][i] == NOT_CONNECTED) continue;

                int newDistance = currentDistance + GRAPH[currentIndex][i];
                if (distanceFromStart[i] > newDistance) {
                    distanceFromStart[i] = newDistance;
                    priorityQueue.add(new Edge(i, newDistance));
                }
            }
        }

        return distanceFromStart;
    }

    private static int[] initDistance(int start) {
        int[] distanceFromStart = new int[VERTEX_COUNT + 1];
        Arrays.fill(distanceFromStart, Integer.MAX_VALUE);
        distanceFromStart[start] = 0;
        return distanceFromStart;
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        DISTANCE_LIMIT = info[1];
        EDGE_COUNT = info[2];
        ITEM_COUNT = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        initGraph(bufferedReader);
    }

    private static void initGraph(BufferedReader bufferedReader) throws IOException {
        GRAPH = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];
        for (int[] row : GRAPH) Arrays.fill(row, NOT_CONNECTED);
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int value = edge[2];
            GRAPH[edge[0]][edge[1]] = value;
            GRAPH[edge[1]][edge[0]] = value;
        }
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int distance;

        public Edge(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
