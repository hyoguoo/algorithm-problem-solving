/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5639
 * Cheat Level: 0
 * Algorithm: Tree
 */

package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearchTree {

    final static Tree tree = new Tree();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            while ((input = bufferedReader.readLine()) != null && input.length() != 0) {
                tree.insert(Integer.parseInt(input));
            }
            bufferedReader.close();
            postOrder(tree.root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        System.out.println(root.data);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        Tree() {
            root = null;
        }

        void insert(int data) {
            if (root == null) root = new Node(data);
            else insert(root, data);
        }

        void insert(Node node, int data) {
            if (node.data > data) {
                if (node.left == null) node.left = new Node(data);
                else insert(node.left, data);
            } else {
                if (node.right == null) node.right = new Node(data);
                else insert(node.right, data);
            }
        }
    }
}
