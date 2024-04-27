/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4108
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minesweeper {

    private static final int MINE_VALUE = -1;
    private static final char MINE = '*';

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = info[0];
            int m = info[1];
            if (n == 0 && m == 0) {
                break;
            }
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = bufferedReader.readLine().toCharArray();
            }

            int[][] solution = solution(map);
            stringBuilder.append(printMap(solution)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int[][] solution(char[][] map) {
        int[][] mineMap = new int[map.length][map[0].length];

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map[n].length; m++) {
                if (map[n][m] == MINE) {
                    mineMap[n][m] = MINE_VALUE;
                } else {
                    mineMap[n][m] = countMines(map, n, m);
                }
            }
        }

        return mineMap;
    }

    private static int countMines(char[][] map, int n, int m) {
        int count = 0;

        for (int[] direction : DIRECTIONS) {
            int nextN = n + direction[0];
            int nextM = m + direction[1];

            if (isInBound(map, nextN, nextM) &&
                    map[nextN][nextM] == MINE) {
                count++;
            }
        }

        return count;
    }

    private static boolean isInBound(char[][] map, int n, int m) {
        return 0 <= n && n < map.length &&
                0 <= m && m < map[n].length;
    }

    private static String printMap(int[][] map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] row : map) {
            for (int cell : row) {
                if (cell == MINE_VALUE) {
                    stringBuilder.append(MINE);
                } else {
                    stringBuilder.append(cell);
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString().trim();
    }
}
