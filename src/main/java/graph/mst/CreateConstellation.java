/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4386
 * Cheat Level: 0
 * Algorithm: Graph / Minimum Spanning Tree / Kruskal Algorithm / Union Find
 */

package graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CreateConstellation {

    final static List<Vertex> VERTEX_LIST = new ArrayList<>();
    final static List<Edge> EDGE_LIST = new ArrayList<>();
    static int VERTEX_COUNT;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(String.format("%.2f", solution()));
    }

    private static double solution() {
        int connectedCount = 0;
        double totalCost = 0;

        for (Edge edge : EDGE_LIST) {
            if (connectedCount == VERTEX_COUNT - 1) break;
            if (isSameParent(edge.from, edge.to)) continue;
            union(edge.from, edge.to);
            totalCost += edge.cost;
            connectedCount++;
        }

        return totalCost;
    }

    private static void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        if (xParent < yParent) parents[yParent] = xParent;
        else parents[xParent] = yParent;
    }

    private static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    private static int findParent(int target) {
        if (target == parents[target]) return target;
        int parent = findParent(parents[target]);
        parents[target] = parent;
        return parent;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < VERTEX_COUNT; i++) {
            double[] vertexInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            VERTEX_LIST.add(new Vertex(i, vertexInfo[0], vertexInfo[1]));
        }

        parents = new int[VERTEX_COUNT];
        for (int i = 0; i < VERTEX_COUNT; i++) parents[i] = i;

        for (int i = 0; i < VERTEX_COUNT; i++) {
            for (int j = i + 1; j < VERTEX_COUNT; j++) {
                double cost = Math.sqrt(Math.pow(VERTEX_LIST.get(i).x - VERTEX_LIST.get(j).x, 2) + Math.pow(VERTEX_LIST.get(i).y - VERTEX_LIST.get(j).y, 2));
                EDGE_LIST.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(EDGE_LIST);
    }

    static class Vertex {
        int index;
        double x;
        double y;

        public Vertex(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}
