/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 4주차 문제 2
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MapleTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        int[][] tree = new int[length][length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            tree[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (isNotZeroArray(tree)) {
            int[][] decrements = getDecrementArray(tree, length);
            decrementTree(tree, decrements);
            count++;
        }

        System.out.println(count);
    }

    public static boolean isNotZeroArray(int[][] tree) {
        for (int[] ints : tree) {
            for (int anInt : ints) {
                if (anInt > 0) return true;
            }
        }
        return false;
    }


    public static int[][] initDecrementArray(int length) {
        int[][] decrements = new int[length][length];
        for (int[] decrement : decrements) Arrays.fill(decrement, 0);
        return decrements;
    }

    public static int[][] getDecrementArray(int[][] tree, int length) {
        int[][] decrements = initDecrementArray(length);

        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                if (tree[i][j] == 0) continue;
                int count = getCount(tree, length, i, j);
                decrements[i][j] = count;
            }
        }
        return decrements;
    }

    private static int getCount(int[][] tree, int length, int i, int j) {
        int count = 0;
        if (i > 0 && tree[i - 1][j] <= 0) count++;
        if (j > 0 && tree[i][j - 1] <= 0) count++;
        if (i < length - 1 && tree[i + 1][j] <= 0) count++;
        if (j < length - 1 && tree[i][j + 1] <= 0) count++;
        return count;
    }

    public static void decrementTree(int[][] tree, int[][] decrements) {
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                tree[i][j] = tree[i][j] - decrements[i][j];
            }
        }
    }
}
