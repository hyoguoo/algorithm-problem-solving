/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1167
 * Cheat Level: 2
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DiameterOfTree2 {

    static List<Node>[] adjacencyList;
    static boolean[] visited;
    static int VERTEX_COUNT;
    static int maxDistance;
    static int maxDistanceVertex;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(maxDistance);
    }

    private static void solution() {
        visited = new boolean[VERTEX_COUNT + 1];
        dfs(1, 0);
        visited = new boolean[VERTEX_COUNT + 1];
        dfs(maxDistanceVertex, 0);
    }

    private static void dfs(int from, int distance) {
        visited[from] = true;
        for (Node node : adjacencyList[from]) {
            if (!visited[node.dist]) {
                dfs(node.dist, distance + node.distance);
            }
        }
        if (maxDistance < distance) {
            maxDistance = distance;
            maxDistanceVertex = from;
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        adjacencyList = new ArrayList[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < VERTEX_COUNT; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int vertex = Integer.parseInt(line[0]);
            for (int j = 1; j < line.length - 1; j += 2) {
                int dist = Integer.parseInt(line[j]);
                int distance = Integer.parseInt(line[j + 1]);
                adjacencyList[vertex].add(new Node(dist, distance));
            }
        }
    }

    static class Node {
        int dist;
        int distance;

        public Node(int dist, int distance) {
            this.dist = dist;
            this.distance = distance;
        }
    }
}
