/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17070
 * Cheat Level: 2
 * Algorithm: Graph / Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovingPipes1 {

    final static int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}};
    final static int EMPTY = 0;
    final static int WALL = -1;
    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        dp = new int[N][N][DIRECTIONS.length];

        for (int i = 0; i < N; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(line[j]);
                if (value == 1) map[i][j] = WALL;
                else map[i][j] = EMPTY;
            }
        }

        solution();
        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }

    private static void solution() {
        dp[0][1][0] = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int[] currentDP = dp[x][y];
                for (int nextDirection = 0; nextDirection < DIRECTIONS.length; nextDirection++) {
                    int[] direction = DIRECTIONS[nextDirection];
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];
                    if (nextX >= N || nextY >= N) continue;
                    if (map[nextX][nextY] == WALL) continue;
                    int[] nextDP = dp[nextX][nextY];
                    switch (nextDirection) {
                        case 0:
                            nextDP[0] += currentDP[0] + currentDP[1];
                            break;
                        case 1:
                            if (map[nextX][y] == WALL || map[x][nextY] == WALL) continue;
                            nextDP[1] += currentDP[0] + currentDP[1] + currentDP[2];
                            break;
                        case 2:
                            nextDP[2] += currentDP[1] + currentDP[2];
                            break;
                    }
                }
            }
        }
    }
}
