/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2511
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CardPlay {

    private static final int ROUND_COUNT = 10;
    private static final int WIN_SCORE = 3;
    private static final int DRAW_SCORE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Cards aCards = new Cards(bufferedReader.readLine());
        Cards bCards = new Cards(bufferedReader.readLine());

        System.out.print(solution(aCards, bCards));
    }

    private static String solution(Cards aCards, Cards bCards) {
        int aTotalScore = 0;
        int bTotalScore = 0;
        Winner lastWinner = Winner.D;

        for (int i = 0; i < ROUND_COUNT; i++) {
            int aCard = aCards.getCard(i);
            int bCard = bCards.getCard(i);

            if (aCard > bCard) {
                aTotalScore += WIN_SCORE;
                lastWinner = Winner.A;
            } else if (aCard < bCard) {
                bTotalScore += WIN_SCORE;
                lastWinner = Winner.B;
            } else {
                aTotalScore += DRAW_SCORE;
                bTotalScore += DRAW_SCORE;
            }
        }

        Winner finalWinner = determineFinalWinner(aTotalScore, bTotalScore, lastWinner);

        return aTotalScore + " " + bTotalScore + "\n" + finalWinner;
    }

    private static Winner determineFinalWinner(int aTotalScore, int bTotalScore, Winner lastWinner) {
        if (aTotalScore > bTotalScore) {
            return Winner.A;
        }
        if (aTotalScore < bTotalScore) {
            return Winner.B;
        }
        return lastWinner;
    }

    enum Winner {
        A, B, D
    }

    static class Cards {

        private final int[] values;

        public Cards(String input) {
            this.values = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        public int getCard(int index) {
            return values[index];
        }
    }
}
