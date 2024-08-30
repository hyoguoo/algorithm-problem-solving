/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2591
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCard {

    private static final int MAX_CARD_NUMBER = 34;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String input) {
        int[] dp = new int[input.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= input.length(); i++) {
            for (int num = 1; num <= MAX_CARD_NUMBER; num++) {
                String cardNumber = String.valueOf(num);
                if (isMatched(input, i, cardNumber)) {
                    dp[i] += dp[i - cardNumber.length()];
                }
            }
        }

        return dp[input.length()];
    }

    private static boolean isMatched(String input, int index, String cardNumber) {
        if (index - cardNumber.length() > input.length() ||
                index < cardNumber.length()) {
            return false;
        }
        String subString = input.substring(index - cardNumber.length(), index);

        return subString.equals(cardNumber);
    }
}
