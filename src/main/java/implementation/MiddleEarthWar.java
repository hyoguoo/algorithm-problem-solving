/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4435
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MiddleEarthWar {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int battleCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int battleNumber = 1; battleNumber <= battleCount; battleNumber++) {
            int[] goodCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            BattleInput battleInput = new BattleInput(goodCounts, evilCounts);
            BattleResult result = solution(battleInput);
            resultBuilder.append("Battle ").append(battleNumber).append(": ");
            switch (result) {
                case GOOD:
                    resultBuilder.append("Good triumphs over Evil");
                    break;
                case EVIL:
                    resultBuilder.append("Evil eradicates all trace of Good");
                    break;
                case TIE:
                    resultBuilder.append("No victor on this battle field");
                    break;
            }
            resultBuilder.append(System.lineSeparator());
        }

        System.out.print(resultBuilder.toString().trim());
    }


    private static BattleResult solution(BattleInput battleInput) {
        int[] goodCounts = battleInput.getGoodCounts();
        int[] evilCounts = battleInput.getEvilCounts();

        GoodRace[] goodRaces = GoodRace.values();
        EvilRace[] evilRaces = EvilRace.values();

        long goodScore = IntStream.range(0, goodRaces.length)
                .mapToLong(i -> (long) goodCounts[i] * goodRaces[i].getScore())
                .sum();

        long evilScore = IntStream.range(0, evilRaces.length)
                .mapToLong(i -> (long) evilCounts[i] * evilRaces[i].getScore())
                .sum();

        if (goodScore > evilScore) {
            return BattleResult.GOOD;
        } else if (goodScore < evilScore) {
            return BattleResult.EVIL;
        } else {
            return BattleResult.TIE;
        }
    }

    private enum BattleResult {
        GOOD, EVIL, TIE
    }

    private enum GoodRace {
        HOBBIT(1),
        HUMAN(2),
        ELF(3),
        DWARF(3),
        EAGLE(4),
        WIZARD(10);

        private final int score;

        GoodRace(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    private enum EvilRace {
        ORC(1),
        HUMAN(2),
        WARG(2),
        GOBLIN(2),
        URUK_HAI(3),
        TROLL(5),
        WIZARD(10);

        private final int score;

        EvilRace(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    private static final class BattleInput {

        private final int[] goodCounts;
        private final int[] evilCounts;

        public BattleInput(int[] goodCounts, int[] evilCounts) {
            this.goodCounts = goodCounts;
            this.evilCounts = evilCounts;
        }

        public int[] getGoodCounts() {
            return goodCounts;
        }

        public int[] getEvilCounts() {
            return evilCounts;
        }
    }
}
