/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3273
 * Cheat Level: 0
 * Algorithm:
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumTwoNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        Arrays.sort(numbers);
        int count = 0;
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else {
                count++;
                left++;
                right--;
            }
        }

        return count;
    }
}
