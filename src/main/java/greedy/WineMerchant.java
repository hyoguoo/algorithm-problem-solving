/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34850
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WineMerchant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        WineMerchantInfo wineMerchantInfo = new WineMerchantInfo(input);

        System.out.print(solution(wineMerchantInfo));
    }

    private static long solution(WineMerchantInfo info) {
        long baseRevenue = (long) info.bottleCount * (long) info.initialPrice;
        long dailyIncreaseRevenue = info.bottleCount * ((long) info.dayCount - 1) * info.increasePerDay;
        long totalDecreaseAmount = (info.bottleCount * ((long) info.bottleCount - 1) / 2) * info.decreasePerBottle;

        return baseRevenue + dailyIncreaseRevenue - totalDecreaseAmount;
    }

    enum InputProperty {
        BOTTLE_COUNT(0),
        DAY_COUNT(1),
        INITIAL_PRICE(2),
        DECREASE_PER_BOTTLE(3),
        INCREASE_PER_DAY(4);

        private final int index;

        InputProperty(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    static class WineMerchantInfo {
        private final int bottleCount;
        private final int dayCount;
        private final int initialPrice;
        private final int decreasePerBottle;
        private final int increasePerDay;

        public WineMerchantInfo(int[] input) {
            this.bottleCount = input[InputProperty.BOTTLE_COUNT.getIndex()];
            this.dayCount = input[InputProperty.DAY_COUNT.getIndex()];
            this.initialPrice = input[InputProperty.INITIAL_PRICE.getIndex()];
            this.decreasePerBottle = input[InputProperty.DECREASE_PER_BOTTLE.getIndex()];
            this.increasePerDay = input[InputProperty.INCREASE_PER_DAY.getIndex()];
        }
    }
}
