/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21924
 * Cheat Level: 0
 * Algorithm: Minimum Spanning Tree / Kruskal Algorithm / Union Find
 */

package graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildCity {

    final static List<Edge> EDGE_LIST = new ArrayList<>();
    static int[] parents;
    static int VERTEX_COUNT, EDGE_COUNT;
    static long TOTAL_COST;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static long solution() {
        int connectedCount = 0;
        long minimumCost = 0;

        for (Edge edge : EDGE_LIST) {
            if (connectedCount == VERTEX_COUNT - 1) break;
            if (isSameParent(edge.from, edge.to)) continue;
            union(edge.from, edge.to);
            minimumCost += edge.cost;
            connectedCount++;
        }

        return connectedCount == VERTEX_COUNT - 1 ? TOTAL_COST - minimumCost : -1;
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
        parents = new int[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) parents[i] = i;
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            EDGE_LIST.add(new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]));
            TOTAL_COST += edgeInfo[2];
        }
        EDGE_LIST.sort(Edge::compareTo);
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
