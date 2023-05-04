/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1967
 * Cheat Level: 2
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiameterOfTree {

    static List<Node>[] adjacencyList;
    static boolean[] visited;
    static int diameter;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        adjacencyList = new ArrayList[length + 1];
        for (int i = 1; i <= length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < length - 1; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = info[0];
            int to = info[1];
            int distance = info[2];
            adjacencyList[from].add(new Node(to, distance));
            adjacencyList[to].add(new Node(from, distance));
        }

        for (int i = 1; i <= length; i++) {
            visited = new boolean[length + 1];
            dfs(i, 0);
        }
        System.out.println(diameter);
    }

    private static void dfs(int start, int distance) {
        visited[start] = true;
        for (Node node : adjacencyList[start]) {
            if (!visited[node.dist]) {
                dfs(node.dist, distance + node.distance);
            }
        }
        diameter = Math.max(diameter, distance);
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
