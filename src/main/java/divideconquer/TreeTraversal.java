/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2263
 * Cheat Level: 3
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraversal {

    final static List<Integer> preorder = new ArrayList<>();
    static int[] inorder, postorder, inorderRootIndex;

    public static void main(String[] args) throws IOException {
        init();
        getInorderRootIndex();
        addPreorder(0, inorder.length - 1, 0, postorder.length - 1);
        printPreorder();
    }

    private static void getInorderRootIndex() {
        inorderRootIndex = new int[inorder.length + 1];
        for (int i = 0; i < inorder.length; i++) {
            inorderRootIndex[inorder[i]] = i;
        }
    }

    private static void addPreorder(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) return;
        int rootIndex = findInorderRootIndex(postorder[postorderEnd]);

        preorder.add(postorder[postorderEnd]);

        addPreorder(inorderStart, rootIndex - 1, postorderStart, postorderStart + (rootIndex - inorderStart) - 1);
        addPreorder(rootIndex + 1, inorderEnd, postorderStart + (rootIndex - inorderStart), postorderEnd - 1);
    }

    private static int findInorderRootIndex(int rootValue) {
        return inorderRootIndex[rootValue];
    }

    private static void printPreorder() {
        preorder.forEach(integer -> System.out.print(integer + " "));
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        inorder = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
