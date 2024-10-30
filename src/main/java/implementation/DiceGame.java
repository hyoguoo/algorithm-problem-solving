/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2476
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bufferedReader.readLine());

        DiceValue[] diceValues = new DiceValue[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            int[] diceInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            diceValues[i] = new DiceValue(diceInfo[0], diceInfo[1], diceInfo[2]);
        }

        System.out.print(solution(diceValues));
    }

    private static int solution(DiceValue[] diceValues) {
        return Arrays.stream(diceValues)
                .mapToInt(DiceValue::getPrize)
                .max()
                .orElseThrow();
    }

    static class DiceValue {

        private static final int THREE_SAME_BONUS = 10000;
        private static final int TWO_SAME_BONUS = 1000;
        private static final int NO_SAME_BONUS = 0;

        private static final int THREE_SAME_WEIGHT = 1000;
        private static final int TWO_SAME_WEIGHT = 100;
        private static final int NO_SAME_WEIGHT = 100;

        private final int first;
        private final int second;
        private final int third;

        public DiceValue(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public int getPrize() {
            if (first == second && second == third) {
                return THREE_SAME_BONUS + first * THREE_SAME_WEIGHT;
            } else if (first == second || first == third) {
                return TWO_SAME_BONUS + first * TWO_SAME_WEIGHT;
            } else if (second == third) {
                return TWO_SAME_BONUS + second * TWO_SAME_WEIGHT;
            } else {
                return NO_SAME_BONUS + Math.max(first, Math.max(second, third)) * NO_SAME_WEIGHT;
            }
        }
    }
}
