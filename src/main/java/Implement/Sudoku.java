/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2580
 * Cheat Level: 0
 * Algorithm: Backtracking
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    static final int SIZE = 9;
    static final int[][] board = new int[SIZE][SIZE];
    static final List<Zero> zeroList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) zeroList.add(new Zero(i, j));
            }
        }

        solution(0);
    }

    private static void solution(int index) {
        if (index == zeroList.size()) {
            printResult();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            Zero zero = zeroList.get(index);
            if (checkPossible(zero.x, zero.y, i)) {
                board[zero.x][zero.y] = i;
                solution(index + 1);
                board[zero.x][zero.y] = 0;
            }
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        System.exit(0);
    }

    private static boolean checkPossible(int x, int y, int reference) {
        return checkWidth(x, reference) && checkHeight(y, reference) && checkArea(x, y, reference);
    }

    private static boolean checkArea(int x, int y, int reference) {
        int offsetX = getOffset(x);
        int offsetY = getOffset(y);
        for (int i = offsetX; i < offsetX + 3; i++) {
            for (int j = offsetY; j < offsetY + 3; j++) {
                if (board[i][j] == reference) return false;
            }
        }
        return true;
    }

    private static int getOffset(int n) {
        return (n / 3) * 3;
    }

    private static boolean checkWidth(int x, int reference) {
        for (int i = 0; i < SIZE; i++) {
            if (board[x][i] == reference) return false;
        }
        return true;
    }

    private static boolean checkHeight(int y, int reference) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][y] == reference) return false;
        }
        return true;
    }
}

class Zero {
    int x;
    int y;

    public Zero(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
