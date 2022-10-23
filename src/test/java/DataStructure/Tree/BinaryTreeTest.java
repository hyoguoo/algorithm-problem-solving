package DataStructure.Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    Tree tree;

    @BeforeEach
    void beforeEach() {
        this.tree = new BinaryTree();
        this.tree.add(5);
        this.tree.add(4);
        this.tree.add(10);
        this.tree.add(7);
        this.tree.add(11);
        this.tree.add(13);
        this.tree.add(6);
        this.tree.add(9);
        this.tree.add(8);
    }

    @Test
    void size() {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 11, 6, 9, 13, 8));
        assertEquals(this.tree.size(), list.size());
    }

    @Test
    void findSuccess() {
        assertEquals(this.tree.find(10).getData(), 10);
    }
    
    @Test
    void bfs() {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 11, 6, 9, 13, 8));
        assertEquals(this.tree.bfs(), list);
    }

    @Test
    void dfs() {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 6, 9, 8, 11, 13));
        assertEquals(this.tree.dfs(), list);
    }

    @Test
    void noChildNodeDelete() {
        this.tree.delete(8);
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 11, 6, 9, 13));
        assertEquals(this.tree.bfs(), list);
    }

    @Test
    void noLeftChildNodeDelete() {
        this.tree.delete(11);
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 13, 6, 9, 8));
        assertEquals(this.tree.bfs(), list);
    }

    @Test
    void noRightChildNodeDelete() {
        this.tree.delete(9);
        List<Integer> list = new ArrayList<>(List.of(5, 4, 10, 7, 11, 6, 8, 13));
        assertEquals(this.tree.bfs(), list);
    }

    @Test
    void allChildNodeDelete() {
        this.tree.delete(10);
        List<Integer> list = new ArrayList<>(List.of(5, 4, 9, 7, 11, 6, 8, 13));
        assertEquals(this.tree.bfs(), list);
    }

    @Test
    void rootNodeDelete() {
        this.tree.delete(5);
        List<Integer> list = new ArrayList<>(List.of(4, 10, 7, 11, 6, 9, 13, 8));
        assertEquals(this.tree.bfs(), list);
    }
}