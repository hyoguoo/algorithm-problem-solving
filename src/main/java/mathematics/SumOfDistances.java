/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2399
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfDistances {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static long solution(int[] numbers) {
        int[] sorted = Arrays.stream(numbers).sorted().toArray();

        long[] prefixSum = new long[sorted.length];
        Arrays.setAll(prefixSum, i ->
                Arrays.stream(sorted, 0, i + 1).asLongStream().sum()
        );
        return 2L * IntStream.range(0, sorted.length)
                .mapToLong(i ->
                        (long) i * sorted[i] - (i == 0 ? 0 : prefixSum[i - 1])
                )
                .sum();
    }
}
