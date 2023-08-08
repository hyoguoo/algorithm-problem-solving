/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28438
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[info[0]][info[1]];
        int[] rowSum = new int[info[0]];
        int[] columnSum = new int[info[1]];
        int operationsCount = info[2];
        for (int i = 0; i < operationsCount; i++) {
            int[] operationInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (operationInfo[0] == 1) rowSum[operationInfo[1] - 1] += operationInfo[2];
            else columnSum[operationInfo[1] - 1] += operationInfo[2];
        }
        int[][] result = solution(matrix, rowSum, columnSum);
        print(result);
    }

    private static int[][] solution(int[][] matrix, int[] rowSum, int[] columnSum) {
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < columnSum.length; j++) {
                matrix[i][j] = rowSum[i] + columnSum[j];
            }
        }

        return matrix;
    }

    private static void print(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : matrix) {
            for (int column : row) {
                stringBuilder.append(column).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
