/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2294
 * Cheat Level: 0
 * Algorithm: Dynamic Programing
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin2 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = info[0];
        int target = info[1];
        int[] numbers = getNumbers(bufferedReader, length, target);
        dp = new int[target + 1];
        Arrays.fill(dp, -1);

        if (target == 0) {
            System.out.println(0);
        } else if (numbers.length == 0) {
            System.out.println(-1);
        } else {
            solution(target, numbers);
            System.out.println(dp[target]);
        }
    }

    private static int[] getNumbers(BufferedReader bufferedReader, int length, int target) throws IOException {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) numbers[i] = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(numbers).filter(number -> number <= target).toArray();
        Arrays.sort(numbers);
        return numbers;
    }

    private static void solution(int target, int[] numbers) {
        for (int number : numbers) dp[number] = 1;

        for (int i = 1; i <= target; i++) {
            calculate(numbers, i);
        }
    }

    private static void calculate(int[] numbers, int i) {
        for (int number : numbers) {
            if (i - number >= 0 && dp[i - number] != -1) {
                if (dp[i] == -1) dp[i] = dp[i - number] + 1;
                else dp[i] = Math.min(dp[i], dp[i - number] + 1);
            }
        }
    }
}
