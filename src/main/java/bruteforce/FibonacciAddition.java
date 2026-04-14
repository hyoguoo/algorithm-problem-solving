/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30824
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciAddition {

    private static final List<Long> FIBONACCI_LIST = new ArrayList<>();
    private static final Long LIMIT = 10_000_000_000_000_000L;

    static {
        FIBONACCI_LIST.add(1L);
        FIBONACCI_LIST.add(1L);
        while (true) {
            long next = FIBONACCI_LIST.get(FIBONACCI_LIST.size() - 1) + FIBONACCI_LIST.get(FIBONACCI_LIST.size() - 2);
            if (next > LIMIT) {
                break;
            }
            FIBONACCI_LIST.add(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            stringBuilder
                    .append(solution((int) info[0], info[1]) ? "YES" : "NO")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int termsCount, long targetSum) {
        if (termsCount == 1) {
            return FIBONACCI_LIST.contains(targetSum);
        }

        for (long fibonacci : FIBONACCI_LIST) {
            if (fibonacci >= targetSum) {
                break;
            }
            if (solution(termsCount - 1, targetSum - fibonacci)) {
                return true;
            }
        }

        return false;
    }
}
