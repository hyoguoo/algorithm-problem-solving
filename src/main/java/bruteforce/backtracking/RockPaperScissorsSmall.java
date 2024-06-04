/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30518
 * Cheat Level: 0
 * Algorithm: Bruteforce / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RockPaperScissorsSmall {

    private static final int MOD = 1_000_000_007;
    private static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Hand myHand = Hand.from(bufferedReader.readLine().toCharArray()[0]);
        char[] array = bufferedReader.readLine().toCharArray();
        Hand[] hands = new Hand[array.length];
        for (int i = 0; i < array.length; i++) {
            hands[i] = Hand.from(array[i]);
        }

        System.out.print(solution(myHand, hands));
    }

    private static long solution(Hand myHand, Hand[] hands) {
        countCases(myHand, hands, 0, null);
        return count;
    }

    private static void countCases(Hand myHand, Hand[] hands, int index, Result previousResult) {
        for (int i = index; i < hands.length; i++) {
            Result currentResult = myHand.compare(hands[i]);
            if (previousResult == Result.WIN &&
                    currentResult == Result.DRAW) {
                continue;
            }
            count = (count + 1) % MOD;
            countCases(hands[i], hands, i + 1, currentResult);
        }
    }

    enum Hand {
        R('R'),
        P('P'),
        S('S');

        private final char handValue;

        Hand(char handValue) {
            this.handValue = handValue;
        }

        public static Hand from(char hand) {
            return Arrays.stream(Hand.values())
                    .filter(h -> h.handValue == hand)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public Result compare(Hand other) {
            if (this == other) {
                return Result.DRAW;
            }

            switch (this) {
                case R:
                    return other == Hand.S ? Result.WIN : Result.LOSE;
                case P:
                    return other == Hand.R ? Result.WIN : Result.LOSE;
                case S:
                    return other == Hand.P ? Result.WIN : Result.LOSE;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    enum Result {
        WIN,
        LOSE,
        DRAW
    }
}
