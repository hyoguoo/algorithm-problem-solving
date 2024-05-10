/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10164
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PathsOnGrid {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static int solution(int sizeN, int sizeM, int k) {
        int[][] dp = new int[sizeN + 1][sizeM + 1];
        dp[1][1] = 1;

        calculatePaths(dp, sizeN, sizeM);

        if (k == 0) {
            return dp[sizeN][sizeM];
        }

        Coordinate kCoordinate = getKPosition(k, sizeM);

        int remainN = sizeN - kCoordinate.n + 1;
        int remainM = sizeM - kCoordinate.m + 1;
        int[][] remainDp = new int[remainN + 1][remainM + 1];

        remainDp[1][1] = dp[kCoordinate.n][kCoordinate.m];

        calculatePaths(remainDp, remainN, remainM);

        return remainDp[remainDp.length - 1][remainDp[0].length - 1];
    }

    private static void calculatePaths(int[][] dp, int sizeN, int sizeM) {
        for (int n = 1; n <= sizeN; n++) {
            for (int m = 1; m <= sizeM; m++) {
                if (n == 1 && m == 1) {
                    continue;
                }
                dp[n][m] = dp[n - 1][m] + dp[n][m - 1];
            }
        }
    }

    private static Coordinate getKPosition(int k, int sizeM) {
        int n = k / sizeM;
        int m = k % sizeM;

        return m == 0
                ? new Coordinate(n, sizeM)
                : new Coordinate(n + 1, m);
    }

    static class Coordinate {
        private final int n;
        private final int m;

        public Coordinate(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
