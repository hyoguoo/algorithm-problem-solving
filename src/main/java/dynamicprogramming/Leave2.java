/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14501 / 15486
 * Cheat Level: 1
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leave2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(bufferedReader.readLine());

        Schedule[] schedules = new Schedule[day + 1];

        for (int i = 1; i <= day; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            schedules[i] = new Schedule(info[0], info[1]);
        }

        System.out.print(getMaxPay(schedules, day));
    }

    private static int getMaxPay(Schedule[] schedules, int maxDay) {
        int[] dp = new int[maxDay + 1];

        for (int day = 1; day <= maxDay; day++) {
            int time = schedules[day].time - 1;
            int pay = schedules[day].pay;
            if (day + time <= maxDay) {
                dp[day + time] = Math.max(dp[day + time], dp[day - 1] + pay);
            }
            dp[day] = Math.max(dp[day], dp[day - 1]);
        }

        return dp[maxDay];
    }

    static class Schedule {
        int time;
        int pay;

        public Schedule(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }
    }
}
