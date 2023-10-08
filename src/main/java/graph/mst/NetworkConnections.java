/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1922
 * Cheat Level: 0
 * Algorithm: Minimum Spanning Tree / Kruskal Algorithm / Union Find
 */

package graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NetworkConnections {

    static final List<Edge> EDGE_LIST = new ArrayList<>();
    static int[] parents;
    static int VERTEX_COUNT, EDGE_COUNT;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int totalCost = 0;
        int connectedCount = 0;

        for (int i = 0; i < EDGE_LIST.size(); i++) {
            Edge edge = EDGE_LIST.get(i);
            if (connectedCount == VERTEX_COUNT - 1) break;
            if (isSameParent(edge.from, edge.to)) continue;
            union(edge.from, edge.to);
            totalCost += edge.cost;
            connectedCount++;
        }

        return totalCost;
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

    private static int findParent(int n) {
        if (n == parents[n]) return n;
        int parent = findParent(parents[n]);
        parents[n] = parent;
        return parent;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        EDGE_COUNT = Integer.parseInt(bufferedReader.readLine());
        parents = new int[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) parents[i] = i;
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            EDGE_LIST.add(new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]));
        }
        EDGE_LIST.sort(Comparator.comparingInt(o -> o.cost));
    }


    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
