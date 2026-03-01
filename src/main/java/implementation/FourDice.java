/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2484
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FourDice {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bufferedReader.readLine());
        DiceHand[] diceHands = new DiceHand[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            List<Integer> dice = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            diceHands[i] = new DiceHand(dice);
        }

        System.out.print(solution(diceHands));
    }

    private static int solution(DiceHand[] diceHands) {
        return Arrays.stream(diceHands)
                .mapToInt(DiceHand::calculatePrize)
                .max()
                .orElse(0);
    }

    enum PrizeRule {
        FOUR_SAME(50000, 5000),
        THREE_SAME(10000, 1000),
        TWO_PAIRS(2000, 500),
        TWO_SAME(1000, 100),
        ALL_DIFFERENT(0, 100);

        private final int basePrize;
        private final int multiplier;

        PrizeRule(int basePrize, int multiplier) {
            this.basePrize = basePrize;
            this.multiplier = multiplier;
        }

        public int getBasePrize() {
            return basePrize;
        }

        public int getMultiplier() {
            return multiplier;
        }
    }

    static class DiceHand {

        private static final int THREE_SAME_COUNT = 3;
        private static final int TWO_SAME_COUNT = 2;
        private static final int ALL_SAME_UNIQUE_COUNT = 1;
        private static final int THREE_SAME_OR_TWO_PAIRS_UNIQUE_COUNT = 2;
        private static final int TWO_SAME_UNIQUE_COUNT = 3;

        private final List<Integer> dice;

        public DiceHand(List<Integer> dice) {
            this.dice = dice;
        }

        public int calculatePrize() {
            Map<Integer, Long> counts = dice.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            if (counts.size() == ALL_SAME_UNIQUE_COUNT) {
                int value = counts.keySet().iterator().next();
                return PrizeRule.FOUR_SAME.getBasePrize() + value * PrizeRule.FOUR_SAME.getMultiplier();
            }

            if (counts.size() == THREE_SAME_OR_TWO_PAIRS_UNIQUE_COUNT) {
                if (counts.containsValue((long) THREE_SAME_COUNT)) {
                    int value = counts.entrySet().stream()
                            .filter(entry -> entry.getValue() == THREE_SAME_COUNT)
                            .map(Map.Entry::getKey)
                            .findFirst()
                            .orElseThrow();
                    return PrizeRule.THREE_SAME.getBasePrize() + value * PrizeRule.THREE_SAME.getMultiplier();
                } else {
                    return PrizeRule.TWO_PAIRS.getBasePrize() +
                            counts.keySet().stream().mapToInt(v -> v * PrizeRule.TWO_PAIRS.getMultiplier()).sum();
                }
            }

            if (counts.size() == TWO_SAME_UNIQUE_COUNT) {
                int value = counts.entrySet().stream()
                        .filter(entry -> entry.getValue() == TWO_SAME_COUNT)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElseThrow();
                return PrizeRule.TWO_SAME.getBasePrize() + value * PrizeRule.TWO_SAME.getMultiplier();
            }

            int maxValue = Collections.max(dice);
            return PrizeRule.ALL_DIFFERENT.getBasePrize() + maxValue * PrizeRule.ALL_DIFFERENT.getMultiplier();
        }
    }
}
