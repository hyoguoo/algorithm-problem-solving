/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6236
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonthlyExpense {

    static final int MAX = 100000 * 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dayCount = info[0];
        int targetWithdrawCount = info[1];

        int[] withdraws = new int[dayCount];
        for (int i = 0; i < dayCount; i++) {
            withdraws[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(withdraws, targetWithdrawCount));
    }

    private static int solution(int[] withdraws, int targetWithdrawCount) {
        int left = Arrays.stream(withdraws).max().orElseThrow();
        int right = MAX;

        while (left <= right) {
            int mid = (left + right) / 2;
            int withdrawCount = calculateWithDrawCount(withdraws, mid);
            if (withdrawCount <= targetWithdrawCount) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    private static int calculateWithDrawCount(int[] withdraws, int withdrawAmount) {
        int withdrawCount = 1;
        int currentWithdraw = 0;

        for (int withdraw : withdraws) {
            if (currentWithdraw + withdraw > withdrawAmount) {
                withdrawCount++;
                currentWithdraw = 0;
            }
            currentWithdraw += withdraw;
        }

        return withdrawCount;
    }
}
