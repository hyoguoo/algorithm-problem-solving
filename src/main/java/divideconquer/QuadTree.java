/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1992
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    static final StringBuilder stringBuilder = new StringBuilder();
    static int N;
    static boolean[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < N; j++) matrix[i][j] = input[j].equals("1");
        }

        recursion(0, 0, N);
        System.out.println(stringBuilder);
    }

    private static void recursion(int x, int y, int length) {
        if (checkIsCompleted(x, y, length)) {
            boolean reference = matrix[x][y];
            stringBuilder.append(reference ? "1" : "0");
            return;
        }
        length /= 2;
        stringBuilder.append("(");
        if (length == 0) recursion(x, y, length);
        recursion(x, y, length);
        recursion(x, y + length, length);
        recursion(x + length, y, length);
        recursion(x + length, y + length, length);
        stringBuilder.append(")");

    }

    private static boolean checkIsCompleted(int x, int y, int length) {
        boolean reference = matrix[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (matrix[i][j] != reference) return false;
            }
        }
        return true;
    }
}
