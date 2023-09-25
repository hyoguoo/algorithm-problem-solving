/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11052
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyCard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] cards = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(cards, n));
    }

    private static int solution(int[] cards, int n) {
        int[] dp = new int[n + 1];

        for (int target = 1; target <= n; target++) {
            for (int count = 1; count <= n; count++) {
                int price = cards[count - 1];
                if (target - count >= 0) dp[target] = Math.max(dp[target], dp[target - count] + price);
            }
        }

        return dp[n];
    }

}
