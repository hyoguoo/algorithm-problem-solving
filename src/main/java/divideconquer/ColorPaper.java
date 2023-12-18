/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2630
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ColorPaper {

    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recursion(paper, n, 0, 0);

        System.out.print(zeroCount + "\n" + oneCount);
    }

    private static void recursion(int[][] paper, int length, int startX, int startY) {
        if (isCompletedSquare(paper, length, startX, startY, paper[startX][startY])) return;

        int half = length / 2;

        if (half == 0) {
            recursion(paper, half, startX, startY);
            return;
        }

        recursion(paper, half, startX, startY);
        recursion(paper, half, startX + half, startY);
        recursion(paper, half, startX, startY + half);
        recursion(paper, half, startX + half, startY + half);
    }

    private static boolean isCompletedSquare(int[][] paper, int length, int startX, int startY, int reference) {
        for (int x = startX; x < startX + length; x++) {
            for (int y = startY; y < startY + length; y++) {
                if (paper[x][y] != reference) return false;
            }
        }

        if (reference == 0) zeroCount++;
        if (reference == 1) oneCount++;

        return true;
    }
}
