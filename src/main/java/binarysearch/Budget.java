/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2512
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Budget {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] budgets = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solution(budgets, m));
    }

    public static int solution(int[] budgets, int m) {
        int left = 0;
        int right = Arrays.stream(budgets).max().orElse(0);

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int budgetSum = getBudgetSum(budgets, mid);

            if (budgetSum <= m) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int getBudgetSum(int[] budgets, int budgetLimit) {
        int sum = 0;

        for (int budget : budgets) {
            sum += Math.min(budget, budgetLimit);
        }

        return sum;
    }
}
