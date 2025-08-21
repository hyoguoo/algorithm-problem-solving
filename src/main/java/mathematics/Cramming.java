/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25373
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class Cramming {

    private static final int REMAIN_DAY = 7;
    private static final long TRI_SUM_6 = 21;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Long.parseLong(bufferedReader.readLine())));
    }

    private static long solution(long n) {
        if (n <= TRI_SUM_6) {
            return LongStream.rangeClosed(1, 6)
                    .filter(k -> tri(k) >= n)
                    .findFirst()
                    .orElse(7);
        }
        long start = ceilDiv(n + TRI_SUM_6);
        return LongStream.iterate(start, k -> k + 1)
                .filter(k -> sumViewed(k) >= n)
                .findFirst()
                .orElseThrow();
    }

    private static long sumViewed(long k) {
        long days = Math.min(REMAIN_DAY, k);
        return days * (2 * k - (days - 1)) / 2;
    }

    private static long tri(long k) {
        return k * (k + 1) / 2;
    }

    private static long ceilDiv(long a) {
        return (a + REMAIN_DAY - 1) / REMAIN_DAY;
    }
}
