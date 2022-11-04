package DataStructureImplement.Tree;

import java.util.Arrays;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(4);
        tree.add(10);
        tree.add(7);
        tree.add(11);
        tree.add(13);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.delete(11);

        tree.preorder(tree.root, 0);

        System.out.println(Arrays.toString(tree.bfs().toArray()));
    }

}
