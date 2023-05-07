/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1197 / 1647
 * Cheat Level: 3
 * Algorithm: Minimum Spanning Tree / Kruskal Algorithm / Union Find
 */

package graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSpanningTree {

    final static List<Edge> EDGE_LIST = new ArrayList<>();
    static int[] parents;
    static int VERTEX_COUNT, EDGE_COUNT;
    static int totalCost = 0;
    static int connectedCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(totalCost);
    }

    private static void solution() {
        for (Edge edge : EDGE_LIST) {
            if (connectedCount == VERTEX_COUNT - 1) break;
            if (isSameParent(edge.from, edge.to)) continue;
            union(edge.from, edge.to);
            totalCost += edge.cost;
            connectedCount++;
        }
    }

    private static void union(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);

        if (parentX < parentY) parents[parentX] = parentY;
        else parents[parentY] = parentX;
    }

    private static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    private static int findParent(int x) {
        if (x == parents[x]) return x;
        int parent = findParent(parents[x]);
        parents[x] = parent;
        return parent;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int cost = edgeInfo[2];
            EDGE_LIST.add(new Edge(from, to, cost));
        }
        EDGE_LIST.sort(Edge::compareTo);

        parents = new int[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) parents[i] = i;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
