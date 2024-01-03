/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1940
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Jumong {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int target = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        Arrays.sort(numbers);

        int count = 0;
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];

        while (left < right) {
            if (sum == target) {
                count++;
                sum -= numbers[right--];
                sum += numbers[right];
            } else if (sum > target) {
                sum -= numbers[right--];
                sum += numbers[right];
            } else {
                sum -= numbers[left++];
                sum += numbers[left];
            }
        }

        return count;
    }
}
