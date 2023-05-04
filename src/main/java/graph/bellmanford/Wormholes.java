/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1865
 * Cheat Level: 5
 * Algorithm: Graph / Bellman-Ford
 */

package graph.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Wormholes {

    static final int INF = 1000000000;
    static int VERTEX_COUNT, EDGE_COUNT, WORMHOLE_COUNT;
    static int[] distance;
    static ArrayList<Edge>[] EDGE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int CASE_COUNT = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < CASE_COUNT; i++) {
            init(bufferedReader);
            System.out.println(solution() ? "YES" : "NO");
        }
    }

    private static boolean solution() {
        for (int i = 1; i <= VERTEX_COUNT; i++) {
            if (bellmanFord(i)) return true;
        }

        return false;
    }

    public static boolean bellmanFord(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 1; i < VERTEX_COUNT; i++) {
            boolean update = false;

            for (int j = 1; j <= VERTEX_COUNT; j++) {
                for (Edge edge : EDGE_LIST[j]) {
                    if (distance[j] != INF && distance[edge.end] > distance[j] + edge.weight) {
                        distance[edge.end] = distance[j] + edge.weight;
                        update = true;
                    }
                }
            }

            if (!update) break;
        }

        for (int i = 1; i <= VERTEX_COUNT; i++) {
            for (Edge edge : EDGE_LIST[i]) {
                if (distance[i] != INF && distance[edge.end] > distance[i] + edge.weight) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void init(BufferedReader bufferedReader) throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        WORMHOLE_COUNT = info[2];

        distance = new int[VERTEX_COUNT + 1];
        EDGE_LIST = new ArrayList[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) {
            EDGE_LIST[i] = new ArrayList<>();
        }

        for (int i = 0; i < EDGE_COUNT + WORMHOLE_COUNT; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            if (i < EDGE_COUNT) {
                EDGE_LIST[start].add(new Edge(end, weight));
                EDGE_LIST[end].add(new Edge(start, weight));
            } else {
                EDGE_LIST[start].add(new Edge(end, -weight));
            }
        }
    }

    static class Edge {
        int end;
        int weight;

        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
