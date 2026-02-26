/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19947
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InvestmentGenius {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(new InvestmentInfo(input[0], input[1])));
    }

    private static long solution(InvestmentInfo investmentInfo) {
        long[] dp = new long[investmentInfo.year + 1];
        dp[0] = investmentInfo.initialAsset;

        for (int i = 1; i <= investmentInfo.year; i++) {
            for (InvestmentType type : InvestmentType.values()) {
                if (i >= type.period) {
                    dp[i] = Math.max(dp[i], type.calculate(dp[i - type.period]));
                }
            }
        }

        return dp[investmentInfo.year];
    }

    enum InvestmentType {
        A(1, 0.05),
        B(3, 0.20),
        C(5, 0.35);

        private final int period;
        private final double interestRate;

        InvestmentType(int period, double interestRate) {
            this.period = period;
            this.interestRate = interestRate;
        }

        public long calculate(long amount) {
            return (long) (amount * (1 + interestRate));
        }
    }

    static class InvestmentInfo {

        private final int initialAsset;
        private final int year;

        public InvestmentInfo(int initialAsset, int year) {
            this.initialAsset = initialAsset;
            this.year = year;
        }
    }
}
