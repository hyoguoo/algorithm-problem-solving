/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16958
 * Cheat Level: 0
 * Algorithm: Graph / Floyd Warshall / Geometry
 */

package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Teleport {

    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static int NODE_COUNT, TELEPORT_TIME;

    public static void main(String[] args) throws IOException {
        Node[] nodes = getNodes();
        initGraph();
        setGraph(nodes);
        floyd();
        printResult();
    }

    private static Node[] getNodes() throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        NODE_COUNT = info[0];
        TELEPORT_TIME = info[1];
        Node[] nodes = new Node[NODE_COUNT];
        for (int i = 0; i < NODE_COUNT; i++) {
            int[] nodeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[i] = new Node(nodeInfo[0] == 1, nodeInfo[1], nodeInfo[2]);
        }
        return nodes;
    }

    private static void initGraph() {
        graph = new int[NODE_COUNT][NODE_COUNT];
        for (int i = 0; i < NODE_COUNT; i++) {
            for (int j = 0; j < NODE_COUNT; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void setGraph(Node[] nodes) {
        for (int start = 0; start < nodes.length; start++) {
            for (int end = 0; end < nodes.length; end++) {
                if (start == end) continue;
                Node startNode = nodes[start];
                Node endNode = nodes[end];
                if (startNode.teleport && endNode.teleport) {
                    graph[start][end] = Math.min(graph[start][end], Math.min(TELEPORT_TIME, getManhattanDistance(startNode, endNode)));
                } else {
                    graph[start][end] = Math.min(graph[start][end], getManhattanDistance(startNode, endNode));
                }
                graph[end][start] = graph[start][end];
            }
        }
    }

    private static int getManhattanDistance(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    private static void floyd() {
        for (int via = 0; via < NODE_COUNT; via++) {
            for (int start = 0; start < NODE_COUNT; start++) {
                for (int end = 0; end < NODE_COUNT; end++) {
                    if (graph[start][via] != Integer.MAX_VALUE && graph[via][end] != Integer.MAX_VALUE) {
                        graph[start][end] = Math.min(graph[start][end], graph[start][via] + graph[via][end]);
                    }
                }
            }
        }
    }

    private static void printResult() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int questionCount = Integer.parseInt(bufferedReader.readLine());
        while (questionCount-- > 0) {
            int[] questionInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startNode = questionInfo[0] - 1;
            int endNode = questionInfo[1] - 1;
            stringBuilder.append(graph[startNode][endNode]).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static class Node {

        int r;
        int c;
        boolean teleport;

        public Node(boolean teleport, int r, int c) {
            this.r = r;
            this.c = c;
            this.teleport = teleport;
        }
    }
}

/*
0 = {int[6]@714} [0, 1, 2, 1, 2, 2]
1 = {int[6]@715} [1, 0, 1, 2, 1, 2]
2 = {int[6]@716} [2, 1, 0, 2, 2, 1]
3 = {int[6]@717} [1, 2, 2, 0, 1, 2]
4 = {int[6]@718} [2, 1, 2, 1, 0, 1]
5 = {int[6]@719} [2, 2, 1, 2, 1, 0]

0 = {int[6]@714} [0, 1, 2, 1, 2, 2]
1 = {int[6]@715} [1, 0, 1, 2, 1, 2]
2 = {int[6]@716} [2, 1, 0, 2, 2, 1]
3 = {int[6]@717} [1, 2, 2, 0, 1, 2]
4 = {int[6]@718} [2, 1, 2, 1, 0, 1]
5 = {int[6]@719} [2, 2, 1, 2, 1, 0]
 */