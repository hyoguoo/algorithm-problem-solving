/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1238
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Party {

    final static int NOT_CONNECTED = -1;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;
    static int TARGET;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        List<Integer> distanceList = new ArrayList<>();
        int[][] result = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];
        int[] targetDijkstra = dijkstra(TARGET);
        for (int startVertex = 1; startVertex <= VERTEX_COUNT; startVertex++) {
            if (startVertex == TARGET) continue;
            result[startVertex] = dijkstra(startVertex);
            distanceList.add(result[startVertex][TARGET] + targetDijkstra[startVertex]);
        }

        return Collections.max(distanceList);
    }

    private static int[] dijkstra(int startVertex) {
        int[] distances = new int[VERTEX_COUNT + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();

            int currentIndex = current.index;
            int currentDistance = current.distance;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (int nextIndex = 1; nextIndex <= VERTEX_COUNT; nextIndex++) {
                int currentToNextDistance = GRAPH[currentIndex][nextIndex];
                if (currentToNextDistance == NOT_CONNECTED) continue;
                int newDistance = currentToNextDistance + currentDistance;
                if (distances[nextIndex] > newDistance) {
                    distances[nextIndex] = newDistance;
                    priorityQueue.add(new Vertex(nextIndex, distances[nextIndex]));
                }
            }
        }

        return distances;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        TARGET = info[2];
        GRAPH = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];
        for (int i = 0; i <= VERTEX_COUNT; i++) Arrays.fill(GRAPH[i], NOT_CONNECTED);
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startVertex = edgeInfo[0];
            int endVertex = edgeInfo[1];
            int distance = edgeInfo[2];
            GRAPH[startVertex][endVertex] = distance;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int index;
        int distance;

        public Vertex(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }
    }
}
