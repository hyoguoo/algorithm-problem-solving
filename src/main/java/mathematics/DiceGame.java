/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10103
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceGame {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roundCount = Integer.parseInt(bufferedReader.readLine());

        DiceInfo[] diceInfos = new DiceInfo[roundCount];

        for (int i = 0; i < roundCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            diceInfos[i] = new DiceInfo(info[0], info[1]);
        }

        System.out.print(solution(diceInfos));
    }

    private static String solution(DiceInfo[] diceInfos) {
        Player player1 = new Player(
                Arrays.stream(diceInfos)
                        .mapToInt(diceInfo -> diceInfo.player1Dice)
                        .toArray()
        );
        Player player2 = new Player(
                Arrays.stream(diceInfos)
                        .mapToInt(diceInfo -> diceInfo.player2Dice)
                        .toArray()
        );

        for (int i = 0; i < diceInfos.length; i++) {
            if (player1.dice[i] > player2.dice[i]) {
                player2.decreaseScore(player1.dice[i]);
            } else if (player1.dice[i] < player2.dice[i]) {
                player1.decreaseScore(player2.dice[i]);
            }
        }

        return player1.score + "\n" + player2.score;
    }

    static class DiceInfo {

        private final int player1Dice;
        private final int player2Dice;

        public DiceInfo(int player1Dice, int player2Dice) {
            this.player1Dice = player1Dice;
            this.player2Dice = player2Dice;
        }
    }

    static class Player {

        private static final int INITIAL_SCORE = 100;
        private final int[] dice;
        private int score;

        public Player(int[] dice) {
            this.dice = dice;
            this.score = INITIAL_SCORE;
        }

        public void decreaseScore(int value) {
            this.score -= value;
        }
    }
}
