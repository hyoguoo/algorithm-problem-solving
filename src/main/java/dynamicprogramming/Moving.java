/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11048
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Moving {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int M = info[1];
        int[][] maze = new int[N][M];
        for (int n = 0; n < N; n++) {
            maze[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solution(maze));
    }

    private static int solution(int[][] maze) {
        int[][] dp = new int[maze.length][maze[0].length];
        dp[0][0] = maze[0][0];

        for (int n = 1; n < maze.length; n++) dp[n][0] = dp[n - 1][0] + maze[n][0];

        for (int m = 1; m < maze[0].length; m++) dp[0][m] = dp[0][m - 1] + maze[0][m];

        for (int n = 1; n < maze.length; n++) {
            for (int m = 1; m < maze[n].length; m++) {
                dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]) + maze[n][m];
            }
        }

        return dp[maze.length - 1][maze[0].length - 1];
    }
}
