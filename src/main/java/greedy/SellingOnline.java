/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1246
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SellingOnline {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int eggCount = info[0];
        int customerCount = info[1];
        int[] prices = new int[customerCount];

        for (int i = 0; i < customerCount; i++) {
            prices[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(eggCount, prices));
    }

    private static String solution(int eggCount, int[] prices) {
        Arrays.sort(prices);
        int maxRevenue = 0;
        int maxPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            int revenue = prices[i] * Math.min(eggCount, prices.length - i);
            if (maxRevenue < revenue) {
                maxRevenue = revenue;
                maxPrice = prices[i];
            }
        }

        return maxPrice + " " + maxRevenue;
    }
}
