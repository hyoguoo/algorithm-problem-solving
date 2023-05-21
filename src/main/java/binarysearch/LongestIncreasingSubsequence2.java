/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12015 / 12738
 * Cheat Level: 3
 * Algorithm: Binary Search / LIS
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(numbers));
    }


    private static int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        list.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            int comparedNumber = list.get(list.size() - 1);
            if (number > comparedNumber) list.add(number);
            else list.set(binarySearch(list, number), number);
        }

        return list.size();
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == target) return mid;
            else if (list.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
