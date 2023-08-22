/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 7일차
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CloudFinderFlag {


    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    final static int TARGET = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int targetCount = info[1];
        int[][] map = new int[N][N];
        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[n] = input;
        }

        System.out.println(solution(map, targetCount));
    }

    private static int solution(int[][] map, int targetCount) {
        int count = 0;

        for (int n = 0; n < map.length; n++) {
            for (int m = 0; m < map[n].length; m++) {
                if (map[n][m] != TARGET && getCount(map, n, m) == targetCount) count++;
            }
        }
        return count;
    }

    private static double getCount(int[][] map, int n, int m) {
        return Arrays.stream(DIRECTIONS)
                .filter(direction -> isInBound(map.length, map[n].length, n + direction[0], m + direction[1]))
                .filter(direction -> map[n + direction[0]][m + direction[1]] == TARGET)
                .count();
    }

    private static boolean isInBound(int N, int M, int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }
}
