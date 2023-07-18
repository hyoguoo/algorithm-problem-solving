/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1744
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Numbering {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        boolean existZero = false;

        for (int number : numbers) {
            if (number > 0) positive.add(number);
            else if (number == 0) existZero = true;
            else negative.add(number);
        }

        return getPositiveSum(positive) + getNegativeSum(negative, existZero);
    }

    private static int getPositiveSum(List<Integer> positive) {
        positive.sort((o1, o2) -> o2 - o1);

        List<Integer> filteredPositive = new ArrayList<>();
        for (Integer integer : positive) {
            if (integer != 1) filteredPositive.add(integer);
        }

        int positiveSum = positive.size() - filteredPositive.size();
        positiveSum += getSumOfList(filteredPositive);

        return positiveSum;
    }

    private static int getNegativeSum(List<Integer> negative, boolean existZero) {
        negative.sort((o1, o2) -> o1 - o2);

        int negativeSum = 0;

        if (negative.size() % 2 == 1) {
            Integer remove = negative.remove(negative.size() - 1);
            if (!existZero) negativeSum += remove;
        }

        negativeSum += getSumOfList(negative);

        return negativeSum;
    }

    private static int getSumOfList(List<Integer> numberList) {
        int sum = 0;
        int multiply = 1;

        for (int i = 0; i < numberList.size(); i++) {
            int value = numberList.get(i).intValue();
            if (i == numberList.size() - 1) {
                sum += value * multiply;
            } else if (i % 2 == 0) {
                multiply = value;
            } else {
                sum += value * multiply;
                multiply = 1;
            }
        }
        return sum;
    }
}
