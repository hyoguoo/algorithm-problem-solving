/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14501
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leave {

    static int[] times;
    static int[] pays;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(bufferedReader.readLine());
        times = new int[day + 1];
        pays = new int[day + 1];

        for (int i = 1; i <= day; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            setTimeTable(i, info);
        }

        System.out.println(getMaxPay(day));
    }

    private static void setTimeTable(int i, int[] input) {
        times[i] = input[0];
        pays[i] = input[1];
    }

    private static int getMaxPay(int day) {
        int[] dp = new int[day + 1];
        for (int i = 1; i <= day; i++) {
            int time = times[i] - 1;
            int pay = pays[i];
            if (i + time <= day) dp[i + time] = Math.max(dp[i + time], dp[i - 1] + pay);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[day];
    }
}
