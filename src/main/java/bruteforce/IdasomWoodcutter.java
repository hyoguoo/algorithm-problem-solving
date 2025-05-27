/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1421
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class IdasomWoodcutter {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int woodCount = info[0];
        int cutCost = info[1];
        int unitPrice = info[2];
        int[] woodsLength = new int[woodCount];
        for (int i = 0; i < woodCount; i++) {
            woodsLength[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(woodsLength, cutCost, unitPrice));
    }

    private static long solution(int[] woodsLength, int cutCost, int unitPrice) {
        int maxLength = Arrays.stream(woodsLength).max().orElse(0);

        return IntStream.rangeClosed(1, maxLength)
                .mapToLong(length -> calculateProfit(woodsLength, length, cutCost, unitPrice))
                .max()
                .orElse(0);
    }

    private static long calculateProfit(int[] woodsLength, int unitLength, int cutCost, int unitPrice) {
        long totalProfit = 0;

        for (int woodLength : woodsLength) {
            if (woodLength < unitLength) {
                continue;
            }

            long pieces = woodLength / unitLength;
            long cutCount = woodLength % unitLength == 0
                    ? pieces - 1
                    : pieces;
            long profit = pieces * unitLength * unitPrice - cutCount * cutCost;

            if (profit > 0) {
                totalProfit += profit;
            }
        }

        return totalProfit;
    }
}
