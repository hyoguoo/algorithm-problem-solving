/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9934
 * Cheat Level: 0
 * Algorithm: Tree
 */

package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompleteBinaryTree {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bufferedReader.readLine());

        int[] array = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(k, array));
    }

    private static String solution(int depth, int[] arr) {
        List<List<Integer>> tree = initTree(depth);

        buildTree(arr, 0, arr.length - 1, 0, depth, tree);

        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> nodes : tree) {
            for (int node : nodes) {
                stringBuilder.append(node).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString().trim();
    }

    private static List<List<Integer>> initTree(int depth) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            tree.add(new ArrayList<>());
        }
        return tree;
    }

    private static void buildTree(
            int[] arr,
            int start,
            int end,
            int currentDepth,
            int depth,
            List<List<Integer>> tree
    ) {
        if (currentDepth == depth) {
            return;
        }

        int mid = (start + end) / 2;
        tree.get(currentDepth).add(arr[mid]);

        buildTree(arr, start, mid - 1, currentDepth + 1, depth, tree);
        buildTree(arr, mid + 1, end, currentDepth + 1, depth, tree);
    }
}
