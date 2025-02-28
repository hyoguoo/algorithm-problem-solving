/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1024
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfSequence {

    private static final int LENGTH_LIMIT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = info[0];
        int minLength = info[1];

        System.out.print(solution(sum, minLength));
    }

    private static String solution(int sum, int minLength) {
        for (int length = minLength; length <= LENGTH_LIMIT; length++) {
            int start = Math.floorDiv(sum - length * (length - 1) / 2, length);
            if (start < 0) {
                continue;
            }
            int end = start + length - 1;

            int sumOfSequence = IntStream.rangeClosed(start, end).sum();
            if (sumOfSequence == sum) {
                return IntStream.rangeClosed(start, end)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
            }
        }

        return "-1";
    }
}
