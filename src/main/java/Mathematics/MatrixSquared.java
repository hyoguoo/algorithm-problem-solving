/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10830
 * Cheat Level: 0
 * Algorithm: Mathematics / Divide Conquer
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixSquared {

    final static int MOD = 1000;
    static long N;
    static long B;
    static long[][] BASE_MATRIX;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        N = info[0];
        B = info[1];
        BASE_MATRIX = new long[(int) N][(int) N];
        for (int i = 0; i < N; i++) {
            BASE_MATRIX[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).map(x -> x % MOD).toArray();
        }

        long[][] result = divideConquer(B);
        printMatrix(result);
    }

    private static void printMatrix(long[][] matrix) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static long[][] divideConquer(long b) {
        if (b == 1) return BASE_MATRIX;
        long[][] dividedMatrix = divideConquer(b / 2);
        if (b % 2 == 0) return multiplyMatrix(dividedMatrix, dividedMatrix);
        else return multiplyMatrix(multiplyMatrix(dividedMatrix, dividedMatrix), BASE_MATRIX);
    }


    private static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] multiplied = new long[(int) N][(int) N];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    multiplied[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                multiplied[i][j] %= MOD;
            }
        }

        return multiplied;
    }
}
