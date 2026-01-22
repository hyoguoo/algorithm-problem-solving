/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25496
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MasterJewelerIms {

    private static final int FATIGUE_LIMIT = 200;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int currentFatigue = info[0];

        int[] fatigueCosts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(currentFatigue, fatigueCosts));
    }

    private static long solution(int currentFatigue, int[] fatigueCosts) {
        return new FatigueCalculator(currentFatigue, fatigueCosts).calculateMaxCraftableCount();
    }

    static class FatigueCalculator {

        private final int initialFatigue;
        private final int[] fatigueCosts;

        public FatigueCalculator(int initialFatigue, int[] fatigueCosts) {
            this.initialFatigue = initialFatigue;
            this.fatigueCosts = fatigueCosts;
        }

        public long calculateMaxCraftableCount() {
            int[] sortedCosts = Arrays.stream(fatigueCosts)
                    .sorted()
                    .toArray();

            int fatigue = initialFatigue;
            long count = 0;
            for (int cost : sortedCosts) {
                if (fatigue >= FATIGUE_LIMIT) {
                    break;
                }
                fatigue += cost;
                count++;
            }
            return count;
        }
    }
}
