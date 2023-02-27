/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2493
 * Cheat Level: 0
 * Algorithm: Stack
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Towers {

    static final Stack<Tower> stack = new Stack<>();
    static final List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(heights);
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void solution(int[] heights) {
        stack.push(new Tower(1, heights[0]));
        result.add(0);
        for (int index = 1; index < heights.length; index++) {
            int height = heights[index];
            int higherTowerIndex = getHigherTowerIndex(height);
            result.add(higherTowerIndex);
            stack.push(new Tower(index + 1, height));
        }
    }

    private static int getHigherTowerIndex(int height) {
        while (!stack.isEmpty()) {
            Tower peekTower = stack.peek();
            if (peekTower.height > height) return peekTower.index;
            stack.pop();
        }

        return 0;
    }

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

/*
5
6 9 5 7 4

0 0 2 2 4
 */