/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15720
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class CowBurger {

    private static final int DISCOUNT_RATE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] burgerPrices = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sidePrices = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] drinkPrices = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(burgerPrices, sidePrices, drinkPrices));
    }

    private static Price solution(int[] burgerPrices, int[] sidePrices, int[] drinkPrices) {
        int[] sortedBurgerPrices = reverseSort(burgerPrices);
        int[] sortedSidePrices = reverseSort(sidePrices);
        int[] sortedDrinkPrices = reverseSort(drinkPrices);

        int discountPrice = calculateDiscountPrice(sortedBurgerPrices, sortedSidePrices, sortedDrinkPrices);
        int totalPrice =
                Arrays.stream(burgerPrices).sum() + Arrays.stream(sidePrices).sum() + Arrays.stream(drinkPrices).sum();

        return new Price(totalPrice, totalPrice - discountPrice);
    }

    private static int calculateDiscountPrice(int[] sortedBurgerPrices,
            int[] sortedSidePrices,
            int[] sortedDrinkPrices) {
        int discountPrice = 0;
        int minMenuCount = Math.min(sortedBurgerPrices.length,
                Math.min(sortedSidePrices.length, sortedDrinkPrices.length));

        for (int i = 0; i < minMenuCount; i++) {
            discountPrice += (sortedBurgerPrices[i] + sortedSidePrices[i] + sortedDrinkPrices[i]) * DISCOUNT_RATE / 100;
        }
        return discountPrice;
    }

    private static int[] reverseSort(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Price {

        private final int totalPrice;
        private final int discountPrice;

        public Price(int totalPrice, int discountPrice) {
            this.totalPrice = totalPrice;
            this.discountPrice = discountPrice;
        }

        @Override
        public String toString() {
            return totalPrice + "\n" + discountPrice;
        }
    }
}
