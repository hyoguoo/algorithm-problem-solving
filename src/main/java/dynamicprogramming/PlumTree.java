/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2240
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlumTree {

    private static final int TREE_COUNT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int plumCount = info[0];
        int moveCount = info[1];
        int[] plums = new int[plumCount + 1];

        for (int i = 1; i <= plumCount; i++) {
            plums[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(plums, moveCount));
    }

    private static int solution(int[] plums, int moveCount) {
        int[][][] dp = initDp(plums, moveCount);

        for (int p = 2; p < plums.length; p++) {
            int plumPosition = plums[p];

            if (plumPosition == 1) {
                dp[p][0][1] = dp[p - 1][0][1] + 1;
                dp[p][0][2] = dp[p - 1][0][2];

                for (int m = 1; m <= moveCount; m++) {
                    dp[p][m][1] = Math.max(dp[p - 1][m][1], dp[p - 1][m - 1][2]) + 1;
                    dp[p][m][2] = Math.max(dp[p - 1][m][2], dp[p - 1][m - 1][1]);
                }
            } else {
                dp[p][0][1] = dp[p - 1][0][1];
                dp[p][0][2] = dp[p - 1][0][2] + 1;

                for (int m = 1; m <= moveCount; m++) {
                    dp[p][m][1] = Math.max(dp[p - 1][m][1], dp[p - 1][m - 1][2]);
                    dp[p][m][2] = Math.max(dp[p - 1][m][2], dp[p - 1][m - 1][1]) + 1;
                }
            }
        }

        return getMaxPlums(plums, moveCount, dp);
    }

    private static int[][][] initDp(int[] plums, int moveCount) {
        int[][][] dp = new int[plums.length + 1][moveCount + 1][TREE_COUNT + 1];

        if (plums[1] == 1) {
            dp[1][0][1] = 1;
        } else {
            dp[1][1][2] = 1;
        }
        return dp;
    }

    private static int getMaxPlums(int[] plums, int moveCount, int[][][] dp) {
        int max = 0;

        for (int m = 0; m <= moveCount; m++) {
            max = Math.max(max, Math.max(dp[plums.length - 1][m][1], dp[plums.length - 1][m][2]));
        }

        return max;
    }
}
