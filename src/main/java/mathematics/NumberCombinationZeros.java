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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Long> result = new ArrayList<>();

        for (Integer num : TEN_MEAURES) {
            result.add(count(n, num) - count(m, num) - count(n - m, num));
        }

        return result.stream()
                .min(Long::compareTo)
                .orElse(0L);
    }

    private static long count(long n, long k) {
        long count = 0;

        for (long i = k; i <= n; i *= k) {
            count += n / i;
        }

        return count;
    }
}
