/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11725
 * Cheat Level: 0
 * Algorithm: Tree / Graph
 */

package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindTreeParents {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        ArrayList<ArrayList<Integer>> tree = initTree(length);

        for (int i = 0; i < length - 1; i++) {
            int[] nodes = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            addNode(tree, nodes);
        }

        int[] parentNode = bfs(length, tree);

        for (int i = 1; i < length; i++) System.out.println(parentNode[i] + 1);
    }

    private static int[] bfs(int length, ArrayList<ArrayList<Integer>> tree) {
        boolean[] visited = new boolean[length];
        int[] parentNodes = new int[length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();

            for (int node : tree.get(v))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNodes[node] = v;
                }
        }
        return parentNodes;
    }

    private static ArrayList<ArrayList<Integer>> initTree(int length) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < length; i++) tree.add(new ArrayList<>());
        return tree;
    }

    private static void addNode(ArrayList<ArrayList<Integer>> tree, int[] nodes) {
        int node1 = nodes[0] - 1;
        int node2 = nodes[1] - 1;
        tree.get(node1).add(node2);
        tree.get(node2).add(node1);
    }
}
