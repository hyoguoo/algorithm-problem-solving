/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2740
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixMultiplication {

    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] infoA = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = infoA[0];
        m = infoA[1];
        int[][] matrixA = getMatrixB(new int[n][m], n, bufferedReader);

        int[] infoB = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = infoB[0];
        k = infoB[1];
        int[][] matrixB = getMatrixB(new int[m][k], m, bufferedReader);

        System.out.print(matrixMultiply(matrixA, matrixB));
    }

    private static int[][] getMatrixB(int[][] matrix, int rows, BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }

    private static StringBuilder matrixMultiply(int[][] matrixA, int[][] matrixB) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int l = 0; l < m; l++) sum += matrixA[i][l] * matrixB[l][j];
                stringBuilder.append(sum).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }
}
