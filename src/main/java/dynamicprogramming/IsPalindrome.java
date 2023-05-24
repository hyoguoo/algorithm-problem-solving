/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10942
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IsPalindrome {

    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(getDP(numbers)));
    }

    private static boolean[][] getDP(int[] numbers) {
        boolean[][] dp = new boolean[numbers.length][numbers.length];

        for (int end = 0; end < numbers.length; end++) {
            dp[end][end] = true;
            for (int start = 0; start < end; start++) {
                if (isPalindrome(numbers, dp, end, start)) dp[start][end] = true;
            }
        }

        return dp;
    }

    private static boolean isPalindrome(int[] numbers, boolean[][] dp, int end, int start) {
        return numbers[start] == numbers[end] && (start + 1 == end || dp[start + 1][end - 1]);
    }

    private static String getResult(boolean[][] dp) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int questionCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < questionCount; i++) {
            int[] rangeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startIndex = rangeInfo[0] - 1;
            int endIndex = rangeInfo[1] - 1;

            stringBuilder.append(dp[startIndex][endIndex] ? 1 : 0).append("\n");
        }

        return stringBuilder.toString();
    }
}
