package DataStructureImplement.Tree;

import java.util.List;

public interface Tree {

    int size();

    void add(int data);

    boolean delete(int data);


    Node find(int data);

    List<Integer> bfs();

    List<Integer> dfs();


    void preorder(Node node, int depth);

    void inorder(Node node, int depth);

    void postorder(Node node, int depth);


}
