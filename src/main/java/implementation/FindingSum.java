/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11441
 * Cheat Level: 0
 * Algorithm: Implementation / Prefix Sum
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int queryCount = Integer.parseInt(bufferedReader.readLine());
        Query[] queries = new Query[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int[] query = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            queries[i] = new Query(query[0] - 1, query[1] - 1);
        }

        System.out.print(solution(numbers, queries));
    }

    private static String solution(int[] numbers, Query[] queries) {
        int[] prefixSum = getPrefixSum(numbers);

        StringBuilder stringBuilder = new StringBuilder();

        for (Query query : queries) {
            stringBuilder.append(prefixSum[query.end + 1] - prefixSum[query.start]).append("\n");
        }

        return stringBuilder.toString().trim();
    }

    private static int[] getPrefixSum(int[] numbers) {
        int[] prefixSum = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i - 1];
        }
        return prefixSum;
    }

    static class Query {

        int start;
        int end;

        public Query(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
