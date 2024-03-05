/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14620
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlowerPaths {

    static final int[][] ZONES = {
            {0, 0},
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static final int TARGET_COUNT = 3;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseCosts()));
    }

    private static int[][] parseCosts() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] garden = new int[n][n];

        for (int i = 0; i < n; i++) {
            garden[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return garden;
    }

    private static int solution(int[][] costs) {
        boolean[][] isExist = new boolean[costs.length][costs[0].length];
        bruteForce(costs, isExist, 0, 0);
        return minCost;
    }

    private static void bruteForce(int[][] costs, boolean[][] isExist, int count, int currentCost) {
        if (count == TARGET_COUNT) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        for (int n = 1; n < costs.length - 1; n++) {
            for (int m = 1; m < costs[n].length - 1; m++) {
                Coordinate coordinate = new Coordinate(n, m);
                int cost = calculateCost(costs, coordinate);
                if (currentCost + cost >= minCost) {
                    continue;
                }
                if (seedFlower(isExist, coordinate)) {
                    bruteForce(costs, isExist, count + 1, currentCost + cost);
                    rollbackFlower(isExist, coordinate);
                }
            }
        }
    }

    private static int calculateCost(int[][] garden, Coordinate coordinate) {
        int cost = 0;

        for (int[] zone : ZONES) {
            int n = coordinate.n + zone[0];
            int m = coordinate.m + zone[1];
            cost += garden[n][m];
        }

        return cost;
    }

    private static boolean seedFlower(boolean[][] isExist, Coordinate coordinate) {
        for (int[] zone : ZONES) {
            int n = coordinate.n + zone[0];
            int m = coordinate.m + zone[1];
            if (isExist[n][m]) {
                return false;
            }
        }

        for (int[] zone : ZONES) {
            int n = coordinate.n + zone[0];
            int m = coordinate.m + zone[1];
            isExist[n][m] = true;
        }

        return true;
    }

    private static void rollbackFlower(boolean[][] isExist, Coordinate coordinate) {
        for (int[] zone : ZONES) {
            int n = coordinate.n + zone[0];
            int m = coordinate.m + zone[1];
            isExist[n][m] = false;
        }
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
