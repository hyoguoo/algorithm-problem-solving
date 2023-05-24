/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2887
 * Cheat Level: 2
 * Algorithm: Graph / Minimum Spanning Tree / Kruskal Algorithm / Union Find
 */

package graph.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PlanetTunnel {

    static int PLANET_COUNT;
    static List<Planet> PLANET_LIST = new ArrayList<>();
    static List<Edge> EDGE_LIST = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int totalCost = 0;
        int connectedCount = 0;

        for (Edge edge : EDGE_LIST) {
            if (connectedCount == PLANET_COUNT - 1) break;
            if (isSameParent(edge.from, edge.to)) continue;
            union(edge.from, edge.to);
            totalCost += edge.cost;
            connectedCount++;
        }

        return totalCost;
    }

    private static boolean isSameParent(int from, int to) {
        return findParent(from) == findParent(to);
    }

    private static void union(int from, int to) {
        int fromParent = findParent(from);
        int toParent = findParent(to);

        if (fromParent < toParent) parents[fromParent] = toParent;
        else parents[toParent] = fromParent;
    }

    private static int findParent(int target) {
        if (target == parents[target]) return target;
        int parent = findParent(parents[target]);
        parents[target] = parent;
        return parent;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PLANET_COUNT = Integer.parseInt(bufferedReader.readLine());

        getPlanetList(bufferedReader);
        getParentsArray();
        getEdgeList();
    }

    private static void getPlanetList(BufferedReader bufferedReader) throws IOException {
        for (int index = 0; index < PLANET_COUNT; index++) {
            int[] planet = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = planet[0];
            int y = planet[1];
            int z = planet[2];
            PLANET_LIST.add(new Planet(index, x, y, z));
        }
    }

    private static void getParentsArray() {
        parents = new int[PLANET_COUNT];
        for (int i = 0; i < PLANET_COUNT; i++) parents[i] = i;
    }

    private static void getEdgeList() {
        PLANET_LIST.sort(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < PLANET_COUNT - 1; i++) {
            int fromIndex = PLANET_LIST.get(i).index;
            int toIndex = PLANET_LIST.get(i + 1).index;
            int fromX = PLANET_LIST.get(i).x;
            int toX = PLANET_LIST.get(i + 1).x;
            int cost = Math.abs(fromX - toX);
            EDGE_LIST.add(new Edge(fromIndex, toIndex, cost));
        }
        PLANET_LIST.sort(Comparator.comparingInt(o -> o.y));
        for (int i = 0; i < PLANET_COUNT - 1; i++) {
            int fromIndex = PLANET_LIST.get(i).index;
            int toIndex = PLANET_LIST.get(i + 1).index;
            int fromY = PLANET_LIST.get(i).y;
            int toY = PLANET_LIST.get(i + 1).y;
            int cost = Math.abs(fromY - toY);
            EDGE_LIST.add(new Edge(fromIndex, toIndex, cost));
        }
        PLANET_LIST.sort(Comparator.comparingInt(o -> o.z));
        for (int i = 0; i < PLANET_COUNT - 1; i++) {
            int fromIndex = PLANET_LIST.get(i).index;
            int toIndex = PLANET_LIST.get(i + 1).index;
            int fromZ = PLANET_LIST.get(i).z;
            int toZ = PLANET_LIST.get(i + 1).z;
            int cost = Math.abs(fromZ - toZ);
            EDGE_LIST.add(new Edge(fromIndex, toIndex, cost));
        }

        EDGE_LIST.sort(Comparator.comparingInt(o -> o.cost));
    }

    static class Planet {
        int index;
        int x;
        int y;
        int z;

        public Planet(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
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
