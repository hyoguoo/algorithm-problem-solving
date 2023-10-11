/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1208
 * Cheat Level: 4
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumOfPartialSequences2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(target == 0 ? solution(numbers, target) - 1 : solution(numbers, target));
    }

    private static long solution(int[] numbers, int target) {
        int[] numbers1 = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
        int[] numbers2 = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
        List<Integer> list1 = getPartialSequence(numbers1);
        List<Integer> list2 = getPartialSequence(numbers2);
        Collections.sort(list1);
        Collections.sort(list2);

        long count = 0;
        for (Integer sum1 : list1) {
            int remainingDifference = target - sum1;
            int upperBound = upperBound(list2, remainingDifference);
            int lowerBound = lowerBound(list2, remainingDifference);
            count += upperBound - lowerBound;
        }

        return count;
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }

        return right;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }

        return right;
    }

    private static List<Integer> getPartialSequence(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < (1 << numbers.length); i++) {
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                if ((i & (1 << j)) > 0) sum += numbers[j];
            }
            list.add(sum);
        }

        return list;
    }
}
