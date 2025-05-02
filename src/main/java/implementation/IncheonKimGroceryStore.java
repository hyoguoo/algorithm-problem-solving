/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12033
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IncheonKimGroceryStore {

    private static final int DISCOUNT_RATE = 25;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCount; i++) {
            bufferedReader.readLine();
            int[] prices = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append(String.format("Case #%d: ", i))
                    .append(solution(prices))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int[] prices) {
        List<Integer> sortedPriceList = Arrays.stream(prices)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> discountedPriceList = new ArrayList<>();

        while (sortedPriceList.size() > 1) {
            int lowestPrice = sortedPriceList.remove(0);
            discountedPriceList.add(lowestPrice);
            removeOriginalPrice(sortedPriceList, lowestPrice);
        }

        return discountedPriceList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static void removeOriginalPrice(List<Integer> priceList, int discountedPrice) {
        long originalPrice = (long) discountedPrice * 100 / (100 - DISCOUNT_RATE);
        int index = priceList.indexOf((int) originalPrice);
        if (index != -1) {
            priceList.remove(index);
        }
    }
}
