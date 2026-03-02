/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5523
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameResult {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roundCount = Integer.parseInt(bufferedReader.readLine());

        Round[] rounds = new Round[roundCount];

        for (int i = 0; i < roundCount; i++) {
            int[] scoreInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            rounds[i] = new Round(scoreInfo[0], scoreInfo[1]);
        }

        System.out.print(solution(rounds));
    }

    private static GameSummary solution(Round[] rounds) {
        int aWinCount = 0;
        int bWinCount = 0;

        for (Round round : rounds) {
            RoundResult roundResult = round.getRoundResult();
            if (roundResult == RoundResult.A_WIN) {
                aWinCount++;
            } else if (roundResult == RoundResult.B_WIN) {
                bWinCount++;
            }
        }

        return new GameSummary(aWinCount, bWinCount);
    }

    enum RoundResult {
        A_WIN, B_WIN, DRAW
    }

    static class Round {

        private final int aScore;
        private final int bScore;

        public Round(int aScore, int bScore) {
            this.aScore = aScore;
            this.bScore = bScore;
        }

        public RoundResult getRoundResult() {
            if (aScore > bScore) {
                return RoundResult.A_WIN;
            } else if (aScore < bScore) {
                return RoundResult.B_WIN;
            } else {
                return RoundResult.DRAW;
            }
        }
    }

    static class GameSummary {

        private final int aWinCount;
        private final int bWinCount;

        public GameSummary(int aWinCount, int bWinCount) {
            this.aWinCount = aWinCount;
            this.bWinCount = bWinCount;
        }

        @Override
        public String toString() {
            return aWinCount + " " + bWinCount;
        }
    }
}
