/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1049
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GuitarStrings {

    static int sixStringMinPrice = Integer.MAX_VALUE;
    static int singleStringMinPrice = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int brokenCount = info[0];
        int brandCount = info[1];

        for (int i = 0; i < brandCount; i++) {
            int[] prices = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (sixStringMinPrice > prices[0]) sixStringMinPrice = prices[0];
            if (singleStringMinPrice > prices[1]) singleStringMinPrice = prices[1];
        }
        if (sixStringMinPrice > singleStringMinPrice * 6) sixStringMinPrice = singleStringMinPrice * 6;

        System.out.println(calculatePrice(brokenCount));
    }

    private static int calculatePrice(int brokenCount) {
        int price = 0;
        while (brokenCount > 0) {
            if (brokenCount >= 6) {
                brokenCount -= 6;
                price += sixStringMinPrice;
            } else if (brokenCount * singleStringMinPrice < sixStringMinPrice) {
                price += brokenCount * singleStringMinPrice;
                brokenCount = 0;
            } else {
                price += sixStringMinPrice;
                brokenCount -= 6;
            }
        }
        return price;
    }
}
