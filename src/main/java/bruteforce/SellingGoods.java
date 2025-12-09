/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1487
 * Cheat Level: 0
 * Algorithm: Implementation / Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SellingGoods {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int buyerCount = Integer.parseInt(bufferedReader.readLine());
        Buyer[] buyers = new Buyer[buyerCount];

        for (int i = 0; i < buyerCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            buyers[i] = new Buyer(info[0], info[1]);
        }

        System.out.print(solution(buyers));
    }

    private static int solution(Buyer[] buyers) {
        return Arrays.stream(buyers)
                .map(buyer -> buyer.price)
                .collect(Collectors.toSet())
                .stream()
                .collect(getPriceToProfitCollector(buyers))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .max(getPriceProfitComparator())
                .map(Entry::getKey)
                .orElse(0);
    }

    private static Collector<Integer, ?, Map<Integer, Integer>> getPriceToProfitCollector(Buyer[] buyers) {
        return Collectors.toMap(
                offeredPrice -> offeredPrice,
                offeredPrice -> Arrays.stream(buyers)
                        .filter(buyer -> buyer.isAccepting(offeredPrice))
                        .filter(buyer -> buyer.isProfitable(offeredPrice))
                        .mapToInt(buyer -> buyer.getProfit(offeredPrice))
                        .sum()
        );
    }

    private static Comparator<Entry<Integer, Integer>> getPriceProfitComparator() {
        return (entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return Integer.compare(entry2.getKey(), entry1.getKey());
            }
            return Integer.compare(entry1.getValue(), entry2.getValue());
        };
    }

    static class Buyer {

        private final int price;
        private final int deliveryFee;

        public Buyer(int price, int deliveryFee) {
            this.price = price;
            this.deliveryFee = deliveryFee;
        }

        public boolean isAccepting(int offeredPrice) {
            return offeredPrice <= price;
        }

        public boolean isProfitable(int offeredPrice) {
            return offeredPrice > deliveryFee;
        }

        public int getProfit(int offeredPrice) {
            return offeredPrice - deliveryFee;
        }
    }
}
