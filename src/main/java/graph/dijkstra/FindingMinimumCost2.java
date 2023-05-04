/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11779
 * Cheat Level: 0
 * Algorithm: Graph / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindingMinimumCost2 {

    final static int NOT_CONNECTED = -1;
    final static int INF = Integer.MAX_VALUE;
    static int START_NODE;
    static int END_NODE;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        RouteInfo[] routeInfo = dijkstra(START_NODE);
        RouteInfo startToEnd = routeInfo[END_NODE];
        printAnswer(startToEnd);
    }

    private static void printAnswer(RouteInfo startToEnd) {
        System.out.println(startToEnd.distance);
        System.out.println(startToEnd.route.size());
        startToEnd.route.forEach(node -> System.out.print(node + " "));
    }

    private static RouteInfo[] dijkstra(int startNode) {
        RouteInfo[] routeInfos = new RouteInfo[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) routeInfos[i] = new RouteInfo(i);
        routeInfos[startNode].distance = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startNode, 0));

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (int nextNode = 1; nextNode <= VERTEX_COUNT; nextNode++) {
                int nextDistance = GRAPH[currentNode][nextNode];
                if (nextDistance == NOT_CONNECTED) continue;

                RouteInfo routeInfo = routeInfos[nextNode];
                int distanceToNextNode = currentDistance + nextDistance;
                if (routeInfo.distance > distanceToNextNode) {
                    priorityQueue.add(new Node(nextNode, distanceToNextNode));

                    routeInfo.distance = distanceToNextNode;
                    routeInfo.route.clear();
                    routeInfo.route.addAll(routeInfos[currentNode].route);
                    routeInfo.route.add(nextNode);
                }
            }
        }

        return routeInfos;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        EDGE_COUNT = Integer.parseInt(bufferedReader.readLine());
        GRAPH = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1];

        for (int i = 0; i < VERTEX_COUNT + 1; i++) Arrays.fill(GRAPH[i], NOT_CONNECTED);
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = edgeInfo[0];
            int end = edgeInfo[1];
            int distance = edgeInfo[2];
            if (GRAPH[start][end] == NOT_CONNECTED) GRAPH[start][end] = distance;
            else GRAPH[start][end] = Math.min(GRAPH[start][end], distance);
        }

        int[] target = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        START_NODE = target[0];
        END_NODE = target[1];
    }

    static class RouteInfo {
        List<Integer> route = new ArrayList<>();
        int distance = INF;

        public RouteInfo(int node) {
            route.add(node);
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
