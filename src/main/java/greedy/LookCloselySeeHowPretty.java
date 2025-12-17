/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33572
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LookCloselySeeHowPretty {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long totalHours = info[1];

        long[] limits = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(limits, totalHours));
    }

    private static Result solution(long[] limits, long totalHours) {
        long safeTotal = Arrays.stream(limits)
                .map(limit -> Math.max(0L, limit - 1))
                .sum();

        return safeTotal >= totalHours
                ? Result.DIMI
                : Result.OUT;
    }

    private enum Result {
        DIMI, OUT
    }
}
