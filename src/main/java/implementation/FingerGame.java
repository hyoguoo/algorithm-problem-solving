/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31866
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FingerGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Mark[] marks = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Mark::of)
                .toArray(Mark[]::new);

        System.out.print(solution(marks[0], marks[1]));
    }

    private static Result solution(Mark mark1, Mark mark2) {
        if (mark1 == Mark.UNKNOWN && mark2 == Mark.UNKNOWN) {
            return Result.DRAW;
        }

        return mark1.compare(mark2);
    }

    enum Result {
        WIN(">"),
        LOSE("<"),
        DRAW("=");

        private final String symbol;

        Result(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    enum Mark {
        ROCK(0),
        SCISSORS(2),
        PAPER(5),
        UNKNOWN(-1);

        private final int fingerCount;

        Mark(int fingerCount) {
            this.fingerCount = fingerCount;
        }

        public static Mark of(int fingerCount) {
            return Arrays.stream(values())
                    .filter(mark -> mark.fingerCount == fingerCount)
                    .findFirst()
                    .orElse(UNKNOWN);
        }

        public Result compare(Mark other) {
            if (this == other) {
                return Result.DRAW;
            }
            if ((this == ROCK && other == SCISSORS) ||
                    (this == SCISSORS && other == PAPER) ||
                    (this == PAPER && other == ROCK) ||
                    other == UNKNOWN) {
                return Result.WIN;
            }
            return Result.LOSE;
        }
    }
}
