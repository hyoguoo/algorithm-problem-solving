/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21866
 * Cheat Level: 0
 * Algorithm: Imp
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class GetCoffeeThroughDrawing {

    private static final int[] MAX_SCORES = {100, 100, 200, 200, 300, 300, 400, 400, 500};
    private static final int MIN_DRAW_SUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(scores));
    }

    private static Result solution(int[] scores) {
        boolean isHacker = IntStream.range(0, Math.min(scores.length, MAX_SCORES.length))
                .anyMatch(i -> scores[i] > MAX_SCORES[i]);

        int total = Arrays.stream(scores).sum();

        if (isHacker) {
            return Result.HACKER;
        } else if (total >= MIN_DRAW_SUM) {
            return Result.DRAW;
        } else {
            return Result.NONE;
        }
    }

    enum Result {
        DRAW("draw"),
        NONE("none"),
        HACKER("hacker");

        private final String value;

        Result(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
