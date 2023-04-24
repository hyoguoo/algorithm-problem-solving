/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5972
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PackageDelivery {

    static int VERTEX_COUNT, EDGE_COUNT;
    static List<Edge>[] EDGE_LIST;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        int[] dijkstra = dijkstra(1);
        System.out.println(dijkstra[VERTEX_COUNT]);
    }

    private static int[] dijkstra(int start) {
        int[] distance = new int[VERTEX_COUNT + 1];
        for (int i = 0; i <= VERTEX_COUNT; i++) distance[i] = Integer.MAX_VALUE;
        distance[start] = 0;

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            int current = poll.to;
            int currentCost = poll.cost;

            if (visited[current]) continue;
            visited[current] = true;

            for (Edge edge : EDGE_LIST[current]) {
                int next = edge.to;
                int nextCost = edge.cost;
                int newDistance = currentCost + nextCost;
                if (distance[next] > newDistance) {
                    distance[next] = newDistance;
                    priorityQueue.add(new Edge(next, newDistance));
                }
            }
        }
        return distance;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        EDGE_LIST = new ArrayList[VERTEX_COUNT + 1];
        for (int i = 0; i <= VERTEX_COUNT; i++) EDGE_LIST[i] = new ArrayList<>();
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int cost = edgeInfo[2];
            EDGE_LIST[from].add(new Edge(to, cost));
            EDGE_LIST[to].add(new Edge(from, cost));
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

/*
6 9
4 5 3
2 4 0
4 1 4
2 1 1
5 6 1
3 6 2
3 2 6
4 5 2
3 4 4
 */