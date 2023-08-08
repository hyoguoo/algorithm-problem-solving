/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 43105
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.util.Arrays;

public class IntegerTriangles {

    public static void main(String[] args) {
        IntegerTriangles integerTriangles = new IntegerTriangles();
        System.out.println(integerTriangles.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];

        for (int[] ints : triangle) {
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int j = 0; j < ints.length; j++) {
                temp[j] = Math.max(dp[j], j - 1 < 0 ? 0 : dp[j - 1]) + ints[j];
            }
            dp = temp;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}