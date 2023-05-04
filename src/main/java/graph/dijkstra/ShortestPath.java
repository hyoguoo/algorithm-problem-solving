/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1753
 * Cheat Level: 3
 * Algorithm: Graph / Dynamic Programming / Dijkstra
 */

package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {

    final static List<Queue<Edge>> edgeList = new ArrayList<>();
    static int[] distanceList;
    static int START;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V = info[0];
        E = info[1];
        START = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < V + 1; i++) edgeList.add(new LinkedList<>());
        distanceList = new int[V + 1];
        for (int i = 0; i < E; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = input[0];
            int end = input[1];
            int weight = input[2];
            edgeList.get(start).add(new Edge(end, weight));
        }

        getDistance();
        printDistance();
    }

    private static void printDistance() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == START) stringBuilder.append(0);
            else if (distanceList[i] == 0) stringBuilder.append("INF");
            else stringBuilder.append(distanceList[i]);
            if (i != V) stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        System.exit(0);
    }

    private static void getDistance() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Edge(START, 0));

        while (!queue.isEmpty()) {
            Edge previous = queue.poll();
            int current = previous.end;
            Queue<Edge> edges = edgeList.get(current);
            while (!edges.isEmpty()) {
                Edge edge = edges.poll();
                int end = edge.end;
                int weight = edge.weight;
                if (distanceList[end] == 0 || distanceList[end] > distanceList[current] + weight) {
                    distanceList[end] = distanceList[current] + weight;
                    queue.add(new Edge(end, distanceList[end]));
                }
            }
        }
    }
}

class Edge {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
