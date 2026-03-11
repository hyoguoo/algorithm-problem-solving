/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25644
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumIncrease {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] prices = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(prices));
    }

    private static int solution(int[] prices) {
        PriceStore priceStore = new PriceStore();
        Arrays.stream(prices)
                .forEach(priceStore::addPrice);

        return priceStore.maxGain;
    }

    static class PriceStore {

        private int minPrice;
        private int maxGain;

        public PriceStore() {
            this.minPrice = Integer.MAX_VALUE;
            this.maxGain = 0;
        }

        public void addPrice(int price) {
            this.minPrice = Math.min(this.minPrice, price);
            this.maxGain = Math.max(price - minPrice, maxGain);
        }
    }
}
