/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1080
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matrix {

    private static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));
    private static final int CONVERT_SIZE = 3;

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        int[][] originalMatrix = parseMatrix(sizeN, sizeM);
        int[][] targetMatrix = parseMatrix(sizeN, sizeM);

        System.out.print(solution(originalMatrix, targetMatrix));
    }

    private static int solution(int[][] originalMatrix, int[][] targetMatrix) {
        int count = 0;

        for (int n = 0; n < originalMatrix.length - CONVERT_SIZE + 1; n++) {
            for (int m = 0; m < originalMatrix[0].length - CONVERT_SIZE + 1; m++) {
                if (originalMatrix[n][m] != targetMatrix[n][m]) {
                    convertMatrix(originalMatrix, n, m);
                    count++;
                }
            }
        }

        return isSameMatrix(originalMatrix, targetMatrix)
                ? count
                : -1;
    }

    private static void convertMatrix(int[][] matrix, int startN, int startM) {
        for (int n = startN; n < startN + CONVERT_SIZE; n++) {
            for (int m = startM; m < startM + CONVERT_SIZE; m++) {
                matrix[n][m] = matrix[n][m] == 0 ? 1 : 0;
            }
        }
    }

    private static boolean isSameMatrix(int[][] originalMatrix, int[][] targetMatrix) {
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[0].length; j++) {
                if (originalMatrix[i][j] != targetMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] parseMatrix(int sizeN, int sizeM) throws IOException {
        int[][] originalMatrix = new int[sizeN][sizeM];

        for (int i = 0; i < sizeN; i++) {
            originalMatrix[i] = Arrays.stream(BUFFERED_READER.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return originalMatrix;
    }
}
