/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12100
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Brute Force
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Easy2048 {

    final static int MOVE_LIMIT = 5;
    static int max = 2;
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        simulating(0);
        System.out.println(max);
    }

    private static void simulating(int moveCount) {
        if (moveCount == MOVE_LIMIT) {
            max = Math.max(max, getMaxValue());
            return;
        }

        for (DIRECTIONS direction : DIRECTIONS.values()) {
            int[][] tempMap = copyMap();
            move(direction);
            simulating(moveCount + 1);
            map = tempMap;
        }
    }

    private static void move(DIRECTIONS direction) {
        boolean[][] isMerged = new boolean[N][M];

        if (direction == DIRECTIONS.RIGHT) {
            for (int n = 0; n < N; n++) {
                for (int m = M - 1; m >= 0; m--) {
                    if (map[n][m] == 0) continue;
                    int tempM = m;
                    while (tempM + 1 < M && map[n][tempM + 1] == 0) {
                        map[n][tempM + 1] = map[n][tempM];
                        map[n][tempM] = 0;
                        tempM++;
                    }
                    if (tempM + 1 < M && map[n][tempM + 1] == map[n][tempM] && !isMerged[n][tempM + 1]) {
                        map[n][tempM + 1] *= 2;
                        map[n][tempM] = 0;
                        isMerged[n][tempM + 1] = true;
                    }
                }
            }
        } else if (direction == DIRECTIONS.LEFT) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m] == 0) continue;
                    int tempM = m;
                    while (tempM - 1 >= 0 && map[n][tempM - 1] == 0) {
                        map[n][tempM - 1] = map[n][tempM];
                        map[n][tempM] = 0;
                        tempM--;
                    }
                    if (tempM - 1 >= 0 && map[n][tempM - 1] == map[n][tempM] && !isMerged[n][tempM - 1]) {
                        map[n][tempM - 1] *= 2;
                        map[n][tempM] = 0;
                        isMerged[n][tempM - 1] = true;
                    }
                }
            }
        } else if (direction == DIRECTIONS.DOWN) {
            for (int n = N - 1; n >= 0; n--) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m] == 0) continue;
                    int tempN = n;
                    while (tempN + 1 < N && map[tempN + 1][m] == 0) {
                        map[tempN + 1][m] = map[tempN][m];
                        map[tempN][m] = 0;
                        tempN++;
                    }
                    if (tempN + 1 < N && map[tempN + 1][m] == map[tempN][m] && !isMerged[tempN + 1][m]) {
                        map[tempN + 1][m] *= 2;
                        map[tempN][m] = 0;
                        isMerged[tempN + 1][m] = true;
                    }
                }
            }
        } else if (direction == DIRECTIONS.UP) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m] == 0) continue;
                    int tempN = n;
                    while (tempN - 1 >= 0 && map[tempN - 1][m] == 0) {
                        map[tempN - 1][m] = map[tempN][m];
                        map[tempN][m] = 0;
                        tempN--;
                    }
                    if (tempN - 1 >= 0 && map[tempN - 1][m] == map[tempN][m] && !isMerged[tempN - 1][m]) {
                        map[tempN - 1][m] *= 2;
                        map[tempN][m] = 0;
                        isMerged[tempN - 1][m] = true;
                    }
                }
            }
        }
    }

    private static int[][] copyMap() {
        int[][] tempMap = new int[N][N];
        for (int i = 0; i < N; i++) tempMap[i] = Arrays.copyOf(map[i], N);
        return tempMap;
    }

    private static int getMaxValue() {
        return Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElseThrow();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = N;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    enum DIRECTIONS {
        RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);

        final int n;
        final int m;

        DIRECTIONS(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
