/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2004
 * Cheat Level: 4
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberCombinationZeros {

    static final List<Integer> TEN_MEAURES = Arrays.asList(2, 5);

    public static void main(String[] args) throws IOException {
        long[] info = Arrays.stream(
                        new BufferedReader(new InputStreamReader(System.in))
                                .readLine()
                                .split(" ")
                )
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static long solution(long n, long m) {
        return TEN_MEAURES.stream()
                .map(
                        num ->
                                getMultiplyCount(n, num)
                                        - getMultiplyCount(m, num)
                                        - getMultiplyCount(n - m, num)
                )
                .collect(Collectors.toList()).stream()
                .min(Long::compareTo)
                .orElse(0L);
    }

    private static long getMultiplyCount(long n, long k) {
        long count = 0;

        while (k <= n) {
            count += n / k;
            n /= k;
        }

        return count;
    }
}
