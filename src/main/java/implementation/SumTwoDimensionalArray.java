/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2167
 * Cheat Level: 0
 * Algorithm: Implementation / Prefix Sum
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumTwoDimensionalArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int M = info[1];
        int[][] array = new int[N][M];
        for (int n = 0; n < N; n++) {
            array[n] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] prefixSum = calculatePrefixSum(N, M, array);

        int K = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < K; k++) {
            int[] query = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = calculateSum(query, prefixSum);
            stringBuilder.append(result).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static int[][] calculatePrefixSum(int N, int M, int[][] array) {
        int[][] prefixSum = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                prefixSum[n][m] = array[n][m];
                if (n > 0) prefixSum[n][m] += prefixSum[n - 1][m];
                if (m > 0) prefixSum[n][m] += prefixSum[n][m - 1];
                if (n > 0 && m > 0) prefixSum[n][m] -= prefixSum[n - 1][m - 1];
            }
        }
        return prefixSum;
    }

    private static int calculateSum(int[] query, int[][] prefixSum) {
        int n1 = query[0] - 1;
        int m1 = query[1] - 1;
        int n2 = query[2] - 1;
        int m2 = query[3] - 1;

        int result = prefixSum[n2][m2];
        if (n1 > 0) result -= prefixSum[n1 - 1][m2];
        if (m1 > 0) result -= prefixSum[n2][m1 - 1];
        if (n1 > 0 && m1 > 0) result += prefixSum[n1 - 1][m1 - 1];

        return result;
    }
}
