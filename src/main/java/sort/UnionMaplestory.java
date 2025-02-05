/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28455
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class UnionMaplestory {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int characterCount = Integer.parseInt(bufferedReader.readLine());
        int[] charactersLevel = new int[characterCount];

        for (int i = 0; i < characterCount; i++) {
            charactersLevel[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(charactersLevel));
    }

    private static UnionCalculator solution(int[] charactersLevel) {
        UnionCalculator unionCalculator = new UnionCalculator();

        Arrays.stream(charactersLevel)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(UnionCalculator.UNION_CHARACTER_LIMIT)
                .forEach(unionCalculator::addLevel);

        return unionCalculator;
    }

    static class UnionCalculator {

        private static final int[] ABILITY_UP_LEVEL = {60, 100, 140, 200, 250};
        private static final int ABILITY_UP_VALUE = 1;
        private static final int UNION_CHARACTER_LIMIT = 42;
        private int totalLevel;
        private int abilityUpCount;

        public UnionCalculator() {
            this.totalLevel = 0;
            this.abilityUpCount = 0;
        }

        public void addLevel(int level) {
            totalLevel += level;
            Arrays.stream(ABILITY_UP_LEVEL)
                    .filter(abilityUpLevel -> level >= abilityUpLevel)
                    .forEach(abilityUpLevel -> abilityUpCount += ABILITY_UP_VALUE);
        }

        @Override
        public String toString() {
            return totalLevel + " " + abilityUpCount;
        }
    }
}
