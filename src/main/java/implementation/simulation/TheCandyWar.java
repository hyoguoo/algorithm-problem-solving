/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9037
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheCandyWar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int childCount = Integer.parseInt(bufferedReader.readLine().trim());
            int[] initialCandies = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            CandyCircle candyCircle = new CandyCircle(childCount, initialCandies);
            stringBuilder
                    .append(solution(candyCircle))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder);
    }

    private static int solution(CandyCircle candyCircle) {
        int cycleCount = 0;
        candyCircle.supplementCandies();

        while (!candyCircle.isAllEqual()) {
            cycleCount++;
            candyCircle.transferCandies();
            candyCircle.supplementCandies();
        }

        return cycleCount;
    }

    enum CandyStatus {
        ODD, EVEN;

        public static CandyStatus of(int candyCount) {
            return candyCount % 2 == 0 ? EVEN : ODD;
        }
    }

    static class CandyCircle {

        private final int childCount;
        private final Child[] children;

        public CandyCircle(int childCount, int[] initialCandies) {
            this.childCount = childCount;
            this.children = new Child[childCount];
            for (int i = 0; i < childCount; i++) {
                this.children[i] = new Child(initialCandies[i]);
            }
        }

        public void supplementCandies() {
            for (Child child : children) {
                if (CandyStatus.of(child.getCandyCount()) == CandyStatus.ODD) {
                    child.receiveFromTeacher();
                }
            }
        }

        public void transferCandies() {
            int[] transferAmounts = new int[childCount];
            for (int i = 0; i < childCount; i++) {
                transferAmounts[i] = children[i].prepareTransfer();
            }

            for (int i = 0; i < childCount; i++) {
                int nextChildIndex = (i + 1) % childCount;
                children[nextChildIndex].receiveFromFriend(transferAmounts[i]);
            }
        }

        public boolean isAllEqual() {
            if (childCount == 0) {
                return true;
            }
            int firstChildCandyCount = children[0].getCandyCount();
            return Arrays.stream(children)
                    .allMatch(child -> child.getCandyCount() == firstChildCandyCount);
        }
    }

    static class Child {

        private int candyCount;

        public Child(int candyCount) {
            this.candyCount = candyCount;
        }

        public int getCandyCount() {
            return candyCount;
        }

        public void receiveFromTeacher() {
            this.candyCount++;
        }

        public int prepareTransfer() {
            int half = this.candyCount / 2;
            this.candyCount -= half;
            return half;
        }

        public void receiveFromFriend(int amount) {
            this.candyCount += amount;
        }
    }
}
