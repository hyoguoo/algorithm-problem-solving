/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11501
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Stock {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] prices = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append(solution(prices)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int[] prices) {
        long maxPrice = 0;
        long profit = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] < maxPrice) {
                profit += maxPrice - prices[i];
            } else {
                maxPrice = prices[i];
            }
        }

        return profit;
    }
}
