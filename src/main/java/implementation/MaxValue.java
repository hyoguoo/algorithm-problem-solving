/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2556
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxValue {

    static final int SIZE = 9;

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseMatrix()));
    }

    private static int[][] parseMatrix() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            matrix[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static String solution(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int maxValueN = -1;
        int maxValueM = -1;

        for (int n = 0; n < SIZE; n++) {
            for (int m = 0; m < SIZE; m++) {
                if (matrix[n][m] > max) {
                    max = matrix[n][m];
                    maxValueN = n;
                    maxValueM = m;
                }
            }
        }

        return max + "\n" + (maxValueN + 1) + " " + (maxValueM + 1);
    }
}
