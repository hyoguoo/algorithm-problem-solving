/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13305
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GasStations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] distances = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prices = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(distances, prices));
    }

    private static long solution(int[] distances, int[] prices) {
        long cost = 0;
        int endIndex = prices.length - 1;

        while (true) {
            int minPriceIndex = findMinPriceIndex(prices, endIndex);
            cost += addDistanceRangeOf(distances, minPriceIndex, endIndex) * prices[minPriceIndex];
            if (minPriceIndex == 0) break;
            endIndex = minPriceIndex;
        }

        return cost;
    }

    private static int findMinPriceIndex(int[] prices, int endIndex) {
        int[] temp = new int[endIndex];
        System.arraycopy(prices, 0, temp, 0, endIndex);

        int min = temp[0];
        int minIndex = 0;

        for (int i = 1; i < endIndex; i++) {
            if (temp[i] < min) {
                min = temp[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static long addDistanceRangeOf(int[] distances, int startIndex, int endIndex) {
        return Arrays.stream(distances, startIndex, endIndex).sum();
    }
}
