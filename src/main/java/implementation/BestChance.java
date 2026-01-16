/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31800
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BestChance {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] profits = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        bufferedReader.readLine();

        System.out.print(solution(profits));
    }

    private static String solution(int[] profits) {
        MaxPair maxPair = MaxPair.from(profits);

        return Arrays.stream(profits)
                .map(profit -> profit - maxPair.otherMax(profit))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static class MaxPair {

        private final int max1;
        private final int max2;

        private MaxPair(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }

        public static MaxPair from(int[] values) {
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            for (int value : values) {
                if (value > first) {
                    second = first;
                    first = value;
                } else if (value > second) {
                    second = value;
                }
            }
            return new MaxPair(first, second);
        }

        public int otherMax(int value) {
            return value == max1 ? max2 : max1;
        }
    }
}
