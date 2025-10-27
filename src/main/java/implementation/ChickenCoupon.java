/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1673
 * Cheat Level: 0
 * Algorithm: Implementation / Mathematics
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChickenCoupon {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            int[] info = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder
                    .append(solution(info[0], info[1]))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int currentCouponCount, int requiredStampCount) {
        int currentStampCount = 0;
        int chickenCount = 0;

        while (currentCouponCount > 0) {
            chickenCount += currentCouponCount;
            currentStampCount += currentCouponCount;
            currentCouponCount = 0;

            if (currentStampCount >= requiredStampCount) {
                int additionalCoupons = currentStampCount / requiredStampCount;
                currentCouponCount += additionalCoupons;
                currentStampCount %= requiredStampCount;
            }
        }

        return chickenCount;
    }
}
