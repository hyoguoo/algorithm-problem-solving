/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1991
 * Cheat Level: 0
 * Algorithm: Tree
 */

package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TreeTraversal {

    static Map<Character, Node> treeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            addNode(input);
        }

        print();
    }

    private static void print() {
        Node root = treeMap.get('A');
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    private static void addNode(String[] input) {
        char root = input[0].charAt(0);
        char left = input[1].charAt(0);
        char right = input[2].charAt(0);

        Node node = treeMap.getOrDefault(root, new Node(root));
        node.left = treeMap.getOrDefault(left, new Node(left));
        node.right = treeMap.getOrDefault(right, new Node(right));

        treeMap.put(root, node);
        treeMap.put(left, node.left);
        treeMap.put(right, node.right);
    }

    private static void preorder(Node root) {
        if (root == null || root.data == '.') return;
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root) {
        if (root == null || root.data == '.') return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    private static void postorder(Node root) {
        if (root == null || root.data == '.') return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }

}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }
}
