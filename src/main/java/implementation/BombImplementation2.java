/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 9일차
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BombImplementation2 {

    final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 0}};
    final static String DOUBLE_GROUND = "@";
    final static String SINGLE_GROUND = "0";

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int bombCount = info[1];
        int[][] values = new int[N][N];
        String[][] groundStatus = new String[N][N];
        for (int n = 0; n < N; n++) {
            groundStatus[n] = bufferedReader.readLine().split(" ");
        }
        List<Coordinate> bombList = new ArrayList<>();
        while (bombCount-- > 0) {
            int[] bombInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int bombN = bombInfo[0] - 1;
            int bombM = bombInfo[1] - 1;
            bombList.add(new Coordinate(bombN, bombM));
        }

        System.out.println(solution(bombList, groundStatus, values));
    }

    private static int solution(List<Coordinate> bombList, String[][] groundStatus, int[][] values) {
        for (Coordinate bomb : bombList) {
            int bombN = bomb.n;
            int bombM = bomb.m;

            for (int[] direction : DIRECTIONS) {
                int nextN = bombN + direction[0];
                int nextM = bombM + direction[1];

                if (!isInBound(groundStatus.length, groundStatus[0].length, nextN, nextM)) continue;
                String status = groundStatus[nextN][nextM];
                if (status.equals(DOUBLE_GROUND)) values[nextN][nextM] += 2;
                else if (status.equals(SINGLE_GROUND)) values[nextN][nextM] += 1;
            }
        }

        return getMaxValue(values);
    }

    private static int getMaxValue(int[][] value) {
        return Arrays.stream(value).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
    }

    private static boolean isInBound(int N, int M, int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
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
