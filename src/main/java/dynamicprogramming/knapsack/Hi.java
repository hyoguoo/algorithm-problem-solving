/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1535
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Knapsack
 */

package dynamicprogramming.knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hi {

    private static final int MAX_HEALTH = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        int[] loss = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] joy = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(loss, joy));
    }

    private static int solution(int[] loss, int[] joy) {
        int[] dp = new int[MAX_HEALTH];

        for (int i = 0; i < loss.length; i++) {
            int healthCost = loss[i];
            int happiness = joy[i];

            for (int h = MAX_HEALTH - 1; h >= healthCost; h--) {
                dp[h] = Math.max(dp[h], dp[h - healthCost] + happiness);
            }
        }

        return Arrays.stream(dp)
                .max()
                .orElseThrow();
    }
}
