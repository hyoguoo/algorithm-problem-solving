/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1780
 */

package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfPaper {

    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        paper = new int[length][length];
        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < length; j++) paper[i][j] = Integer.parseInt(input[j]);
        }

        recursion(0, 0, length);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    private static void recursion(int x, int y, int length) {
        if (checkIsCompleted(x, y, length)) return;
        length /= 3;
        if (length == 0) {
            recursion(x, y, length);
        } else {
            recursion(x, y, length);
            recursion(x + length, y, length);
            recursion(x + length * 2, y, length);
            recursion(x, y + length, length);
            recursion(x + length, y + length, length);
            recursion(x + length * 2, y + length, length);
            recursion(x, y + length * 2, length);
            recursion(x + length, y + length * 2, length);
            recursion(x + length * 2, y + length * 2, length);
        }
    }


    private static boolean checkIsCompleted(int x, int y, int length) {
        int reference = paper[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[i][j] != reference) return false;
            }
        }

        if (reference == -1) minusOne++;
        if (reference == 0) zero++;
        if (reference == 1) plusOne++;
        return true;
    }
}