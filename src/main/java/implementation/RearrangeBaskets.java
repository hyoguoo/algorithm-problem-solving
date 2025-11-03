/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10812
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RearrangeBaskets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int basketCount = info[0];
        int rearrangementCount = info[1];

        Baskets baskets = new Baskets(basketCount);
        Rearrangement[] rearrangements = new Rearrangement[rearrangementCount];

        for (int i = 0; i < rearrangementCount; i++) {
            int[] rearrangementInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            rearrangements[i] = new Rearrangement(
                    rearrangementInfo[0] - 1,
                    rearrangementInfo[1] - 1,
                    rearrangementInfo[2] - 1
            );
        }

        System.out.print(solution(rearrangements, baskets));
    }

    private static Baskets solution(Rearrangement[] rearrangements, Baskets baskets) {
        Arrays.stream(rearrangements).forEach(baskets::rearrange);
        return baskets;
    }

    static class Baskets {

        private final int[] basketValues;

        public Baskets(int basketCount) {
            this.basketValues = new int[basketCount];
            for (int i = 0; i < basketCount; i++) {
                basketValues[i] = i + 1;
            }
        }

        public void rearrange(Rearrangement rearrangement) {
            int[] temp = Arrays.copyOfRange(basketValues, rearrangement.startIndex, rearrangement.endIndex + 1);
            int index = rearrangement.startIndex;

            for (int i = rearrangement.middleIndex; i <= rearrangement.endIndex; i++) {
                basketValues[index++] = temp[i - rearrangement.startIndex];
            }
            for (int i = rearrangement.startIndex; i < rearrangement.middleIndex; i++) {
                basketValues[index++] = temp[i - rearrangement.startIndex];
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(basketValues).replaceAll("[\\[\\],]", "");
        }
    }

    static class Rearrangement {

        private final int startIndex;
        private final int endIndex;
        private final int middleIndex;

        public Rearrangement(int startIndex, int endIndex, int middleIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.middleIndex = middleIndex;
        }
    }
}
