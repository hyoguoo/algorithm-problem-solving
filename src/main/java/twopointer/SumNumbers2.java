/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2003
 * Cheat Level: 0
 * Algorithm: Implementation / Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumNumbers2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = info[1];

        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        if (numbers.length == 0) return numbers[0] == target ? 1 : 0;

        int leftIndex = 0;
        int sum = 0;
        int count = 0;

        for (int number : numbers) {
            sum += number;
            while (sum > target) sum -= numbers[leftIndex++];
            if (sum == target) count++;
        }

        return count;
    }
}
