/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1068
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tree {

    static final int ROOT = -1;
    static final int REMOVE = -2;
    static int count = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(bufferedReader.readLine());
        int[] nodes = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int removeNode = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[nodeCount];

        solution(nodes, removeNode);
        System.out.println(count);
    }

    private static void solution(int[] nodes, int removeNode) {
        int rootIndex = getRootIndex(nodes);
        removeNodeRecursively(nodes, removeNode);
        calculateLeafCount(nodes, rootIndex);
    }

    private static int getRootIndex(int[] nodes) {
        int rootIndex = 0;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == ROOT) {
                rootIndex = i;
                break;
            }
        }

        return rootIndex;
    }

    private static void removeNodeRecursively(int[] nodes, int removeNode) {
        nodes[removeNode] = REMOVE;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == removeNode) {
                removeNodeRecursively(nodes, i);
            }
        }
    }

    private static void calculateLeafCount(int[] nodes, int node) {
        boolean isLeaf = true;
        visit[node] = true;
        if (nodes[node] == REMOVE) return;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == node && !visit[i]) {
                calculateLeafCount(nodes, i);
                isLeaf = false;
            }
        }
        if (isLeaf) count++;
    }
}
