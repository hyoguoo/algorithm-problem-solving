/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15489
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PascalTriangle15489 {

    private static final int SIZE = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static int solution(int r, int c, int w) {
        int[][] pascal = calculatePascalTriangle();

        return calculateAreaSum(pascal, r, c, w);
    }

    private static int calculateAreaSum(int[][] pascal, int r, int c, int w) {
        int sum = 0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += pascal[r + i][c + j];
            }
        }

        return sum;
    }

    private static int[][] calculatePascalTriangle() {
        int[][] pascal = new int[SIZE + 1][SIZE + 1];
        pascal[1][1] = 1;

        for (int i = 2; i <= SIZE; i++) {
            pascal[i][1] = 1;
            pascal[i][i] = 1;
            for (int j = 2; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        return pascal;
    }
}
