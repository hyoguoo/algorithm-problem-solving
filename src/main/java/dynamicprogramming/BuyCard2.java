/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16194
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyCard2 {

    static final int NOT_BUYING = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int buyTarget = Integer.parseInt(bufferedReader.readLine());
        int[] cards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(
                solution(
                        cards,
                        buyTarget
                )
        );
    }

    private static int solution(int[] cards, int buyTarget) {
        int[] dp = new int[buyTarget + 1];
        Arrays.fill(dp, NOT_BUYING);

        for (int i = 0; i <= buyTarget; i++) {
            for (int cardIndex = 1; cardIndex <= buyTarget; cardIndex++) {
                int price = cards[cardIndex - 1];
                for (int buyCount = 1; i + cardIndex * buyCount <= buyTarget; buyCount++) {
                    if (dp[i] == NOT_BUYING) {
                        dp[i + cardIndex * buyCount] = dp[i] + price * buyCount;
                    } else if (i + cardIndex * buyCount <= buyTarget) {
                        dp[i + cardIndex * buyCount] = Math.min(
                                dp[i + cardIndex * buyCount],
                                dp[i] + price * buyCount
                        );
                    }
                }
            }
        }

        return dp[buyTarget];
    }
}
