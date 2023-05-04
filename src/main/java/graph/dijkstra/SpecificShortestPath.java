/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1504
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SpecificShortestPath {

    final static int BLOCKED = -1;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;
    static int[][] GRAPH;
    static int TARGET1;
    static int TARGET2;

    public static void main(String[] args) throws IOException {
        init();
        long answer = solution();
        System.out.println(answer);
    }

    private static long solution() {
        int[] distancesFromStart = getShortestDistances(1);
        int[] distancesTargetFrom1 = getShortestDistances(TARGET1);
        int[] distancesTargetFrom2 = getShortestDistances(TARGET2);

        if (getDistance(distancesFromStart, TARGET1) == Integer.MAX_VALUE || getDistance(distancesTargetFrom1, TARGET2) == Integer.MAX_VALUE || getDistance(distancesTargetFrom2, VERTEX_COUNT) == Integer.MAX_VALUE) return -1;

        long startTo1To2ToN = getDistance(distancesFromStart, TARGET1) + getDistance(distancesTargetFrom1, TARGET2) + getDistance(distancesTargetFrom2, VERTEX_COUNT);
        long startTo2To1ToN = getDistance(distancesFromStart, TARGET2) + getDistance(distancesTargetFrom2, TARGET1) + getDistance(distancesTargetFrom1, VERTEX_COUNT);

        return Math.min(startTo1To2ToN, startTo2To1ToN);
    }

    private static int getDistance(int[] distances, int target) {
        return distances[target];
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        GRAPH = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];

        for (int i = 0; i < VERTEX_COUNT + 1; i++) Arrays.fill(GRAPH[i], BLOCKED);
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            GRAPH[edge[0]][edge[1]] = edge[2];
            GRAPH[edge[1]][edge[0]] = edge[2];
        }
        int[] targets = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TARGET1 = targets[0];
        TARGET2 = targets[1];
    }

    private static int[] getShortestDistances(int start) {
        int[] distances = new int[VERTEX_COUNT + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentIndex = current.index;
            int currentDistance = current.distance;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (int nextIndex = 1; nextIndex <= VERTEX_COUNT; nextIndex++) {
                int nextDistance = GRAPH[currentIndex][nextIndex];
                if (nextDistance == BLOCKED) continue;
                if (distances[nextIndex] > currentDistance + nextDistance) {
                    distances[nextIndex] = currentDistance + nextDistance;
                    priorityQueue.add(new Node(nextIndex, distances[nextIndex]));
                }
            }
        }

        return distances;
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
