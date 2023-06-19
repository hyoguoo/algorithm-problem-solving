/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1799
 * Cheat Level: 2
 * Algorithm: Implementation / Backtracking
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop {

    final static List<Coordinate> BLACK_ENABLE_LIST = new ArrayList<>();
    final static List<Coordinate> WHITE_ENABLE_LIST = new ArrayList<>();
    final static int BISHOP = 2;
    final static int AVAILABLE = 1;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int blackMaxCount = backtracking(BLACK_ENABLE_LIST, 0, 0, 0);
        int whiteMaxCount = backtracking(WHITE_ENABLE_LIST, 0, 0, 0);

        return blackMaxCount + whiteMaxCount;
    }

    private static int backtracking(List<Coordinate> enableList, int index, int count, int maxCount) {
        if (index == enableList.size()) {
            return Math.max(count, maxCount);
        }

        for (int i = index; i < enableList.size(); i++) {
            Coordinate enableCoordinate = enableList.get(i);
            if (checkDiagonal(enableCoordinate.n, enableCoordinate.m)) {
                board[enableCoordinate.n][enableCoordinate.m] = BISHOP;
                maxCount = backtracking(enableList, i + 1, count + 1, maxCount);
                board[enableCoordinate.n][enableCoordinate.m] = AVAILABLE;
            }
        }

        return maxCount;
    }

    private static boolean checkDiagonal(int n, int m) {
        int sum = n + m;
        int sub = n - m;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + j == sum && board[i][j] == BISHOP) return false;
                if (i - j == sub && board[i][j] == BISHOP) return false;
            }
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];
        for (int n = 0; n < N; n++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < N; m++) {
                int value = input[m];
                if (value == AVAILABLE) {
                    if (isBlack(n, m)) BLACK_ENABLE_LIST.add(new Coordinate(n, m));
                    else WHITE_ENABLE_LIST.add(new Coordinate(n, m));
                }
                board[n][m] = value;
            }
        }
    }

    private static boolean isBlack(int n, int m) {
        return (n + m) % 2 == 0;
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
