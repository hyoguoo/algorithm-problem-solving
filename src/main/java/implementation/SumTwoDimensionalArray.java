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
import java.util.stream.Stream;

public class SumTwoDimensionalArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        int[][] values = new int[sizeN][sizeM];
        for (int n = 0; n < sizeN; n++) {
            values[n] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int queryCount = Integer.parseInt(bufferedReader.readLine());

        Query[] queries = new Query[queryCount];
        for (int k = 0; k < queryCount; k++) {
            int[] query = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            queries[k] = new Query(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }

        System.out.print(solution(values, queries));
    }

    private static String solution(int[][] values, Query[] queries) {
        Matrix matrix = new Matrix(values);
        StringBuilder stringBuilder = new StringBuilder();

        Stream.of(queries)
                .forEach(
                        query ->
                                stringBuilder.append(matrix.getSum(query)).append("\n")
                );

        return stringBuilder.toString().trim();
    }

    static class Matrix {

        private final int[][] values;
        private final int[][] prefixSum;

        public Matrix(int[][] values) {
            this.values = values;
            this.prefixSum = calculatePrefixSum();
        }

        private int[][] calculatePrefixSum() {
            int[][] prefixSum = new int[values.length][values[0].length];
            prefixSum[0][0] = values[0][0];

            for (int n = 1; n < values.length; n++) {
                prefixSum[n][0] = prefixSum[n - 1][0] + values[n][0];
            }
            for (int m = 1; m < values[0].length; m++) {
                prefixSum[0][m] = prefixSum[0][m - 1] + values[0][m];
            }
            for (int n = 1; n < values.length; n++) {
                for (int m = 1; m < values[0].length; m++) {
                    prefixSum[n][m] =
                            prefixSum[n - 1][m]
                                    + prefixSum[n][m - 1]
                                    - prefixSum[n - 1][m - 1]
                                    + values[n][m];
                }
            }

            return prefixSum;
        }

        public int getSum(Query query) {
            int sum = prefixSum[query.n2][query.m2];

            if (query.n1 > 0) {
                sum -= prefixSum[query.n1 - 1][query.m2];
            }
            if (query.m1 > 0) {
                sum -= prefixSum[query.n2][query.m1 - 1];
            }
            if (query.n1 > 0 && query.m1 > 0) {
                sum += prefixSum[query.n1 - 1][query.m1 - 1];
            }

            return sum;
        }
    }

    static class Query {

        private final int n1;
        private final int m1;
        private final int n2;
        private final int m2;

        public Query(int n1, int m1, int n2, int m2) {
            this.n1 = n1;
            this.m1 = m1;
            this.n2 = n2;
            this.m2 = m2;
        }
    }
}
