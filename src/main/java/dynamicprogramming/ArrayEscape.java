/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11909
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayEscape {

    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] graph = new int[N][N];
        for (int n = 0; n < N; n++) {
            graph[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(graph));
    }

    private static int solution(int[][] graph) {
        int[][] dp = new int[graph.length][graph.length];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        dp[0][0] = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int currentN = current.n;
            int currentM = current.m;

            for (int[] direction : DIRECTIONS) {
                int nextN = currentN + direction[0];
                int nextM = currentM + direction[1];
                if (!isInBound(graph, nextN, nextM)) continue;
                int movingCost = getMovingCost(graph[currentN][currentM], graph[nextN][nextM]);
                if (dp[nextN][nextM] > dp[currentN][currentM] + movingCost) {
                    dp[nextN][nextM] = dp[currentN][currentM] + movingCost;
                    queue.add(new Coordinate(nextN, nextM));
                }
            }
        }

        return dp[graph.length - 1][graph.length - 1];
    }

    private static int getMovingCost(int fromValue, int toValue) {
        if (fromValue > toValue) return 0;
        return toValue - fromValue + 1;
    }

    private static boolean isInBound(int[][] graph, int n, int m) {
        return n >= 0 && n < graph.length && m >= 0 && m < graph[n].length;
    }

    static class Coordinate {
        int n;
        int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
