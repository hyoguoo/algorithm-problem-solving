/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5063
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TGN {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCount = Integer.parseInt(bufferedReader.readLine());

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int revenueWithoutAds = info[0];
            int revenueWithAds = info[1];
            int adCost = info[2];

            stringBuilder.append(solution(revenueWithoutAds, revenueWithAds, adCost)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static ProfitCompareResult solution(int revenueWithoutAds, int revenueWithAds, int adCost) {
        int profit = revenueWithAds - adCost;
        return ProfitCompareResult.of(Integer.compare(profit, revenueWithoutAds));
    }

    enum ProfitCompareResult {
        ADVERTISE(1, "advertise"),
        DO_NOT_ADVERTISE(-1, "do not advertise"),
        DOES_NOT_MATTER(0, "does not matter");

        private final int value;
        private final String message;

        ProfitCompareResult(int value, String message) {
            this.value = value;
            this.message = message;
        }

        public static ProfitCompareResult of(int value) {
            return Arrays.stream(ProfitCompareResult.values())
                    .filter(profitCompareResult -> profitCompareResult.value == value)
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
