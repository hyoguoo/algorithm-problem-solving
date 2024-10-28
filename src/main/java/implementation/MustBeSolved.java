/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26043
 * Cheat Level: 0
 * Algorithm:
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MustBeSolved {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int queryCount = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Query[] queries = new Query[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int[] query = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            queries[i] = new Query(query[0], query[1]);
        }

        System.out.print(solution(numbers, queries));
    }

    private static String solution(int[] numbers, Query[] queries) {
        int[] prefixSum = calculatePrefixSum(numbers);

        StringBuilder stringBuilder = new StringBuilder();

        for (Query query : queries) {
            int sum = prefixSum[query.endIndex] - prefixSum[query.startIndex - 1];
            stringBuilder.append(sum).append("\n");
        }

        return stringBuilder.toString().trim();
    }

    private static int[] calculatePrefixSum(int[] numbers) {
        int[] sortedNumbers = Arrays.stream(numbers)
                .sorted()
                .toArray();

        int[] prefixSum = new int[numbers.length + 1];

        for (int i = 1; i <= numbers.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + sortedNumbers[i - 1];
        }

        return prefixSum;
    }

    static class Query {

        private final int startIndex;
        private final int endIndex;

        public Query(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
}
