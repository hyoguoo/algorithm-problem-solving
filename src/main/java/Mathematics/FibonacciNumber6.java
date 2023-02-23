/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2749 / 11444
 * Cheat Level: 3
 * Algorithm: Mathematics / Divide Conquer
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber6 {

    final static long MOD = 1000000007L;
    final static long[][] BASE_MATRIX = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(bufferedReader.readLine());

        long[][] matrix = divideConquer(target);
        System.out.println(matrix[0][1]);
    }

    private static long[][] divideConquer(long target) {
        if (target == 1) return BASE_MATRIX;
        long[][] dividedMatrix = divideConquer(target / 2);
        if (target % 2 == 0) return multiplyMatrix(dividedMatrix, dividedMatrix);
        else return multiplyMatrix(multiplyMatrix(dividedMatrix, dividedMatrix), BASE_MATRIX);
    }

    private static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] multiplied = new long[2][2];

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
