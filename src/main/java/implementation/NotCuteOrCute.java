/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10866
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NotCuteOrCute {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int queryCount = Integer.parseInt(bufferedReader.readLine());

        Result[] results = new Result[queryCount];

        for (int i = 0; i < queryCount; i++) {
            results[i] = Result.of(bufferedReader.readLine());
        }

        System.out.print(solution(results) ? "Junhee is cute!" : "Junhee is not cute!");
    }

    private static boolean solution(Result[] results) {
        return Arrays.stream(results)
                .filter(result -> result == Result.CUTE)
                .count()
                >
                Arrays.stream(results)
                        .filter(result -> result == Result.NOT_CUTE)
                        .count();
    }

    enum Result {
        NOT_CUTE("0"),
        CUTE("1");

        private final String value;

        Result(String value) {
            this.value = value;
        }

        public static Result of(String input) {
            return Arrays.stream(Result.values())
                    .filter(result -> result.value.equals(input))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
