/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: -
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.util.Arrays;

public class Budget {

    public int solution(int[] budgets, int M) {
        int left = 0;
        int right = Arrays.stream(budgets).max().orElse(0);

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int budgetSum = getBudgetSum(budgets, mid);

            if (budgetSum <= M) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int getBudgetSum(int[] budgets, int budgetLimit) {
        int sum = 0;

        for (int budget : budgets) {
            sum += Math.min(budget, budgetLimit);
        }

        return sum;
    }
}
